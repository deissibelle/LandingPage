package com.ds.sibelle.components

import androidx.compose.runtime.Composable
import com.ds.sibelle.styles.SocialLinksStyle
import com.ds.sibelle.util.Constants.WEBSITE
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(){
    Column (
        modifier = Modifier
            .margin (
            25.px
        )
            .padding { topBottom(25.px) }
            .minWidth(40.px)
            .borderRadius (20.px)
            .backgroundColor(Colors.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
         SocialLinks()
    }
}

@Composable
 private fun SocialLinks(){
    Link(
        path =  WEBSITE



    ){
        FaFacebook(
            modifier = SocialLinksStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path =  WEBSITE

    ){
        FaTwitter(modifier = SocialLinksStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path =  WEBSITE

    ){
        FaInstagram(modifier = SocialLinksStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG
        )

    }

    Link(
        path =  WEBSITE

    ){

        FaLinkedin(modifier = SocialLinksStyle.toModifier().margin(bottom = 40.px),
            size = IconSize.LG

        )
    }

}