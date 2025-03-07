package com.ds.sibelle.components

import androidx.compose.runtime.Composable
import com.ds.sibelle.models.Theme
import com.ds.sibelle.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(
    name:String,
    index: Int,
    animatedPercentage: Int,
    progressBarHeight:CSSSizeValue<CSSUnit.px> =5.px,
    percentage: CSSSizeValue<CSSUnit.percent> =50.percent

){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .margin (topBottom = 10.px)
            .maxWidth(500.px)
            .padding(topBottom = 5.px)


    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            P(
                attrs = Modifier
                    .margin (topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)

                    .toAttrs()
            ){
                Text(name)

            }
            P(
                attrs = Modifier
                    .margin (topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)

                    .toAttrs()
            ){
                Text("${animatedPercentage}")

            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(progressBarHeight)
                .backgroundColor(Theme.LighterGray.rgb)

        )
        Box(
            modifier = Modifier
                .fillMaxWidth(percentage)
                .height(progressBarHeight)
                .backgroundColor(Theme.Primary.rgb)
                .transition(Transition.of(
                    property = "width",
                    duration = 1000.ms,
                    delay= 100.ms*index
                ))

        )

    }


}