package com.edd.androiddevchallenge.petpet.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max


/**
 * Taken from [StackOverflow](https://stackoverflow.com/questions/61022452/any-ideas-on-the-list-with-fit-wrap-width-on-item-in-jetpack-compose)
 * due to [FlowRow] being deprecated
 */
@Suppress("KDocUnresolvedReference")
@Composable
fun WrappingRow(
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start,
    verticalGap: Dp = 0.dp,
    horizontalGap: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Layout(content, modifier) { measurables, constraints ->
        val horizontalGapInPx = horizontalGap.roundToPx()
        val verticalGapInPx = verticalGap.roundToPx()

        val rows = mutableListOf<MeasuredRow>()
        val itemConstraints = constraints.copy(minWidth = 0)

        measurables.forEach {
            val lastRow = rows.lastOrNull()
            val placeable = it.measure(itemConstraints)

            if (lastRow != null && lastRow.width + horizontalGapInPx + placeable.width <= constraints.maxWidth) {
                lastRow.items.add(placeable)
                lastRow.width += horizontalGapInPx + placeable.width
                lastRow.height = max(lastRow.height, placeable.height)
            } else {
                val nextRow = MeasuredRow(
                    items = mutableListOf(placeable),
                    width = placeable.width,
                    height = placeable.height
                )
                rows.add(nextRow)
            }
        }

        val width = rows.maxOfOrNull { row -> row.width } ?: 0
        val height = rows.sumBy { row -> row.height } + max(verticalGapInPx.times(rows.size - 1), 0)

        val coercedWidth = width.coerceIn(constraints.minWidth, constraints.maxWidth)
        val coercedHeight = height.coerceIn(constraints.minHeight, constraints.maxHeight)

        layout(coercedWidth, coercedHeight) {
            var y = 0
            rows.forEach {
                var x = when (alignment) {
                    Alignment.Start -> 0
                    Alignment.CenterHorizontally -> (coercedWidth - it.width) / 2
                    Alignment.End -> coercedWidth - it.width
                    else -> error("Unsupported alignment")
                }
                for (item in it.items) {
                    item.place(x, y)
                    x += item.width + horizontalGapInPx
                }
                y += it.height + verticalGapInPx
            }
        }
    }
}

private data class MeasuredRow(
    val items: MutableList<Placeable>,
    var width: Int,
    var height: Int
)