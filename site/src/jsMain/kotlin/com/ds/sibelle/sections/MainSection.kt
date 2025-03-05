package com.ds.sibelle.sections

import androidx.compose.runtime.Composable
import com.ds.sibelle.components.header
import com.ds.sibelle.components.socialBar
import com.ds.sibelle.models.Section
import com.ds.sibelle.models.Theme
import com.ds.sibelle.util.Constants.FONT_FAMILY
import com.ds.sibelle.util.Constants.LOREM_IPSUM_SHORTEST
import com.ds.sibelle.util.Constants.SECTION_WIDTH
import com.ds.sibelle.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.Text



@Composable
fun mainSection(){
val  breakpoint = rememberBreakpoint()
    Box (
       modifier = Modifier.id(Section.Home.id)
           .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter

    ){
        mainBackground()
        mainContent(breakpoint = breakpoint)
    }

}

@Composable
fun mainBackground(){
    Image(
        modifier = Modifier.fillMaxSize()
            .objectFit(ObjectFit.Cover),
        src = Res.Image.background,
        alt = "Background Image"
    )

}

@Composable
fun mainContent(breakpoint: Breakpoint){
    Column(
     modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,

    ){
        header()
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent
            ),
                numColumns = numColumns(base=1,md=2)
            ){
                mainText(breakpoint = breakpoint)
                mainImage()

            }

        }

    }

}

@Composable
fun mainText(breakpoint: Breakpoint) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD) {
            socialBar()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.px) // Ajoutez un padding pour éviter que le texte ne touche les bords
        ) {
            P(
                attrs = Modifier
                    .display(DisplayStyle.Block)
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 10.px else 20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Hello, I'm")
            }
            P(
                attrs = Modifier
                    .margin(top = 20.px, bottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 68.px else 40.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("Jonathan Smith")
            }
            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("Mobile & Web Developer/Designer")
            }
            P(
                attrs = Modifier
                    .margin(bottom = 25.px)
                    .maxWidth(400.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(15.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(LOREM_IPSUM_SHORTEST)
            }
            Button(
                attrs = Modifier
                    .height(40.px)
                    .width(120.px) // Ajustez la largeur pour que le texte "Hire me" soit entièrement visible
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Link(
                    modifier = Modifier
                        .color(Colors.White)
                        .textDecorationLine(TextDecorationLine.None),
                    text = "Hire me",
                    path = Section.Contact.path
                )
            }
        }
    }
}
@Composable
fun mainImage() {
    Column(
        modifier = Modifier
            .fillMaxSize(80.percent)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            src = Res.Image.main,
            alt = "Main Image"
        )
    }
}