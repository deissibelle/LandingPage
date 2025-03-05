package com.ds.sibelle.components

import androidx.compose.runtime.Composable
import com.ds.sibelle.models.Section
import com.ds.sibelle.models.Theme
import com.ds.sibelle.styles.LogoStyle
import com.ds.sibelle.styles.NavigationItemStyle
import com.ds.sibelle.util.Constants.FONT_FAMILY
import com.ds.sibelle.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun header(){
    val breakpoint = rememberBreakpoint()
    Row (
        modifier = Modifier.fillMaxWidth( if (breakpoint <= Breakpoint.MD) 80.percent else 90.percent)
            .margin (topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        leftSide(breakpoint=breakpoint)
        if (breakpoint > Breakpoint.MD ){
            rightSide()
        }

    }
}

@Composable
fun leftSide(breakpoint: Breakpoint){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD){
            FaBars(
                modifier = Modifier.margin (right = 15.px),
                size = IconSize.XL
            )
        }

        Image(
            modifier = LogoStyle.toModifier(),
            src = Res.Image.logo,
            description = "Logo"

        )
    }

}


@Composable
fun rightSide(){
    Row(
        modifier = Modifier.fillMaxWidth()
            .borderRadius (50.px )
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(20.px)
        ,
        horizontalArrangement = Arrangement.End
    ) {
        Section.entries.toTypedArray().take(6).forEach { section: Section ->
            Link(
                modifier = NavigationItemStyle.toModifier().padding(right = 30.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                path=section.path,
                text = section.title


            )
        }

    }

}