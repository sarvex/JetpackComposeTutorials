package com.smarttoolfactory.tutorial1_1basics.chapter3_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.*
import com.smarttoolfactory.tutorial1_1basics.ui.components.StyleableTutorialText


val textBackgroundColor = Color(0xff2196F3)
val composableBackgroundColor = Color(0xffFF9800)

@Composable
fun Tutorial3_2Screen3() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    var message by remember { mutableStateOf("Type to monitor overflow") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 50.dp)
                .background(Color(0xffFBE9E7))
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {

            StyleableTutorialText(
                text = "Custom padding modifiers without **offset** or **constrainWidth**\n" +
                        "Second one with only constraintWidth and " +
                        "third one uses **constrains.offset()** to measure placeable dimensions",
                bullets = false
            )
            CustomPaddingSamples(message)

            StyleableTutorialText(
                text = "only **measurable.measure(constraint)** called for the layouts below. " +
                        "Padding requires offset to measure placeable without the " +
                        "region reserved for padding",
                bullets = false
            )
            LayoutOnlySamples(message)

            StyleableTutorialText(
                text = "**Constraints.constrainWidth()** restrains max width " +
                        "placeables of this composable can have. Since we constrain width " +
                        "to maxWidth - arrowWidth" +
                        " placeables can grow more than required.",
                bullets = false
            )
            ConstrainWidthSamples(message)

            StyleableTutorialText(
                text = "**Constraints.offset(x,y)** is used to limit measure placeable without the " +
                        "area used for arrow and padding",
                bullets = false
            )
            ConstraintsOffsetSample(message)
        }

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = message,
            label = { Text("Main") },
            placeholder = { Text("Set text to change main width") },
            onValueChange = { newValue: String ->
                message = newValue
            }
        )
    }
}

@Composable
private fun CustomPaddingSamples(message: String) {
    Column(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .background(composableBackgroundColor)
            .paddingNoOffsetNoConstrain(10.dp)
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    Column(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .background(composableBackgroundColor)
            .paddingWithConstrainOnly(10.dp)
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    Column(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .background(composableBackgroundColor)
            .paddingWithOffsetAndConstrain(10.dp)
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

}


@Composable
private fun LayoutOnlySamples(message: String) {

    ComposableLayoutOnly(
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableLayoutOnly(
        modifier = Modifier.padding(vertical = 4.dp),
        paddingStart = 20,
        paddingTop = 20,
        paddingBottom = 20,
        paddingEnd = 20,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableLayoutOnly(
        modifier = Modifier.padding(vertical = 4.dp),
        arrowWidth = 0,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableLayoutOnly(
        modifier = Modifier.padding(vertical = 4.dp),
        arrowWidth = 0,
        paddingStart = 20,
        paddingTop = 20,
        paddingBottom = 20,
        paddingEnd = 20,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }
}

@Composable
private fun ConstrainWidthSamples(message: String) {
    ComposableWithConstrainWidth(
        modifier = Modifier
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableWithConstrainWidth(
        modifier = Modifier
            .padding(vertical = 4.dp),
        paddingStart = 20,
        paddingTop = 20,
        paddingBottom = 20,
        paddingEnd = 20,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableWithConstrainWidth(
        modifier = Modifier
            .padding(vertical = 4.dp),
        arrowWidth = 0,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableWithConstrainWidth(
        modifier = Modifier.padding(vertical = 4.dp),
        arrowWidth = 0,
        paddingStart = 20,
        paddingTop = 20,
        paddingBottom = 20,
        paddingEnd = 20,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }
}

@Composable
private fun ConstraintsOffsetSample(message: String) {
    ComposableConstraintsOffset(
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableConstraintsOffset(
        modifier = Modifier.padding(vertical = 4.dp),
        paddingStart = 20,
        paddingTop = 20,
        paddingBottom = 20,
        paddingEnd = 20,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableConstraintsOffset(
        modifier = Modifier.padding(vertical = 4.dp),
        arrowWidth = 0,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }

    ComposableConstraintsOffset(
        modifier = Modifier.padding(vertical = 4.dp),
        arrowWidth = 0,
        paddingStart = 20,
        paddingTop = 20,
        paddingBottom = 20,
        paddingEnd = 20,
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier.background(textBackgroundColor)
        )
    }
}


@Composable
private fun ComposableLayoutOnly(
    modifier: Modifier = Modifier,
    arrowWidth: Int = 70,
    paddingStart: Int = 0,
    paddingTop: Int = 0,
    paddingEnd: Int = 0,
    paddingBottom: Int = 0,
    content: @Composable () -> Unit
) {

    val rect = remember { CustomRect() }
    val contentRect = remember { CustomRect() }

    Layout(
        modifier = drawBackgroundRectangles(modifier, rect, contentRect),
        content = content
    ) { measurables: List<Measurable>, constraints: Constraints ->
        val offsetX: Int = (paddingStart + paddingEnd) + arrowWidth
        val offsetY: Int = (paddingTop + paddingBottom)

        val placeables = measurables.map { measurable: Measurable ->
            measurable.measure(constraints)
        }

        val desiredWidth: Int = (placeables.maxOf { it.width } + offsetX)
        val desiredHeight: Int = (placeables.sumOf { it.height } + offsetY)

        createLayout(
            rect,
            desiredWidth,
            desiredHeight,
            contentRect,
            arrowWidth,
            paddingStart,
            paddingTop,
            placeables
        )
    }
}

@Composable
private fun ComposableWithConstrainWidth(
    modifier: Modifier = Modifier,
    arrowWidth: Int = 70,
    paddingStart: Int = 0,
    paddingTop: Int = 0,
    paddingEnd: Int = 0,
    paddingBottom: Int = 0,
    content: @Composable () -> Unit
) {

    val rect = remember { CustomRect() }
    val contentRect = remember { CustomRect() }

    Layout(
        modifier = drawBackgroundRectangles(modifier, rect, contentRect),
        content = content
    ) { measurables: List<Measurable>, constraints: Constraints ->
        val offsetX: Int = (paddingStart + paddingEnd) + arrowWidth
        val offsetY: Int = (paddingTop + paddingBottom)

        val placeables = measurables.map { measurable: Measurable ->
            measurable.measure(constraints)
        }

        // 🔥🔥 Constraint width+offsetX to maxWidth and height+offsetY to maxHeight of constraints
        val desiredWidth: Int =
            constraints.constrainWidth(placeables.maxOf { it.width } + offsetX)
        val desiredHeight: Int =
            constraints.constrainHeight(placeables.sumOf { it.height } + offsetY)

        createLayout(
            rect,
            desiredWidth,
            desiredHeight,
            contentRect,
            arrowWidth,
            paddingStart,
            paddingTop,
            placeables
        )
    }
}

@Composable
private fun ComposableConstraintsOffset(
    modifier: Modifier = Modifier,
    arrowWidth: Int = 70,
    paddingStart: Int = 0,
    paddingTop: Int = 0,
    paddingEnd: Int = 0,
    paddingBottom: Int = 0,
    content: @Composable () -> Unit
) {

    val rect = remember { CustomRect() }
    val contentRect = remember { CustomRect() }

    Layout(
        modifier = drawBackgroundRectangles(modifier, rect, contentRect),
        content = content
    ) { measurables: List<Measurable>, constraints: Constraints ->

        val offsetX: Int = (paddingStart + paddingEnd) + arrowWidth
        val offsetY: Int = (paddingTop + paddingBottom)

        val placeables = measurables.map { measurable: Measurable ->
            // 🔥 With constraints.offset we limit placeable width/height to maxWidth/Height - offsetX/Y
            // Even without arrow it's required to limit width/height for placeable to take space
            // when padding is applied
            measurable.measure(constraints.offset(-offsetX, -offsetY))
        }

        val desiredWidth: Int = placeables.maxOf { it.width } + offsetX
        val desiredHeight: Int = placeables.sumOf { it.height } + offsetY

        createLayout(
            rect,
            desiredWidth,
            desiredHeight,
            contentRect,
            arrowWidth,
            paddingStart,
            paddingTop,
            placeables
        )
    }
}

private fun MeasureScope.createLayout(
    rect: CustomRect,
    desiredWidth: Int,
    desiredHeight: Int,
    contentRect: CustomRect,
    arrowWidth: Int,
    paddingStart: Int,
    paddingTop: Int,
    placeables: List<Placeable>
): MeasureResult {
    rect.set(0f, 0f, desiredWidth.toFloat(), desiredHeight.toFloat())
    contentRect.set(arrowWidth.toFloat(), 0f, desiredWidth.toFloat(), desiredHeight.toFloat())


    val xPos = paddingStart + arrowWidth
    val yPos = paddingTop
    var yNext = 0
    return layout(desiredWidth, desiredHeight) {

        placeables.forEach { placeable: Placeable ->
            placeable.placeRelative(xPos, yPos + yNext)
            yNext += placeable.height
        }
    }
}

@Composable
private fun drawBackgroundRectangles(
    modifier: Modifier,
    rect: CustomRect,
    contentRect: CustomRect
) = modifier
    .drawBehind {
        drawRoundRect(color = Color.White, cornerRadius = CornerRadius(30f, 30f))
        // This rectangle is drawn behind our whole composable
        drawRect(
            color = Color.Red,
            topLeft = Offset(rect.left, rect.top),
            size = Size(rect.width, rect.height),
            style = Stroke(3f)
        )

        // This rectangle is drawn behind our content(imaginary arrow is excluded)
        // to show how offset and constraintWidth effects layout

        drawRect(
            color = Color.Blue,
            topLeft = Offset(contentRect.left, contentRect.top),
            size = Size(contentRect.width, contentRect.height),
            style = Stroke(3f)
        )

    }

private data class CustomRect(
    var left: Float = 0f,
    var top: Float = 0f,
    var right: Float = 0f,
    var bottom: Float = 0f
) {

    fun set(left: Float, top: Float, right: Float, bottom: Float) {
        this.left = left
        this.top = top
        this.right = right
        this.bottom = bottom
    }

    val height: Float
        get() {
            return bottom - top
        }

    val width: Float
        get() {
            return right - left
        }

    override fun toString(): String {
        return "left: $left, top: $top, right: $right, bottom: $bottom, " +
                "width: $width, height: $height"
    }
}