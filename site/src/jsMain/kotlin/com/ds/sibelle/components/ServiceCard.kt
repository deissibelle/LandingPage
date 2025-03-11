package com.ds.sibelle.components

import androidx.compose.runtime.Composable
import com.ds.sibelle.models.Service
import com.ds.sibelle.models.Theme
import com.ds.sibelle.styles.ServiceSectionStyle
import com.ds.sibelle.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(service: Service){
    Column (
        modifier = ServiceSectionStyle.toModifier()
            .maxWidth(300.px)
            .margin(all=20.px)
            .padding (all = 20.px)


    ){
        Box(
            modifier = Modifier
                .id("iconBox")
                .padding (all= 10.px)
                .margin(bottom = 20.px)
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )

                .borderRadius(
                    topLeft = 20.px,
                    topRight=20.px,
                    bottomLeft = 20.px,
                    bottomRight = 0.px
                )
        ) {
          Image(
              modifier = Modifier.size(40.px),
              src =service.icon,
              alt = service.imageDesc
          )

        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(bottom = 10.px, top = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(service.title)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(bottom = 0.px, top = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(service.description)
        }
    }
}