package com.ds.sibelle.sections

import androidx.compose.runtime.*
import com.ds.sibelle.components.SectionTitle
import com.ds.sibelle.components.SkillBar
import com.ds.sibelle.models.Section
import com.ds.sibelle.models.Skill
import com.ds.sibelle.models.Theme
import com.ds.sibelle.styles.AboutSectionStyle
import com.ds.sibelle.styles.AboutTextStyle
import com.ds.sibelle.util.Constants.FONT_FAMILY
import com.ds.sibelle.util.Constants.LOREM_IPSUM_SHORT
import com.ds.sibelle.util.Constants.SECTION_WIDTH
import com.ds.sibelle.util.ObserveViewportEntered
import com.ds.sibelle.util.Res
import com.ds.sibelle.util.animateNumbers
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column

import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlinx.coroutines.launch


@Composable
fun AboutSection(){
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding (topBottom = 150.px),
        contentAlignment = Alignment.Center
    ) {
 AboutContent()

    }
}


@Composable
fun AboutContent(){
    val breakpoint = rememberBreakpoint()

    Column (
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent)
            .maxWidth(1200.px)
    ){
      SimpleGrid(
          modifier = Modifier.fillMaxWidth(
              if (breakpoint>= Breakpoint.MD) 90.percent else 100.percent
          ),
          numColumns = numColumns(base = 1, md = 2)){
          if(breakpoint >= Breakpoint.MD){
              AboutImage()
          }

          AboutMe()


          }

    }
}

@Composable
fun AboutImage(){
    Box (
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center

    ){
        Image(
            modifier = AboutSectionStyle.toModifier().fillMaxWidth(80.percent),
            src = Res.Image.about,
            alt = "About Image"

        )
    }
}

@Composable
fun AboutMe() {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { mutableStateListOf(0, 0, 0, 0, 0) }

    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0,
        onViewportEntered = {
            viewportEntered = true
            Skill.entries.forEach { skill ->
                scope.launch {
                    animateNumbers(
                        number = skill.percentage.value.toInt(),
                        onUpdate = {
                            animatedPercentage[skill.ordinal] = it
                        }
                    )
                }
            }
        }
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)
        P(
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(LOREM_IPSUM_SHORT)
        }
        Skill.entries.forEach { skill ->
            SkillBar(
                name = skill.title,
                index = skill.ordinal,
                percentage = if (viewportEntered) skill.percentage else 0.percent,
                animatedPercentage = if (viewportEntered) animatedPercentage[skill.ordinal] else 0
            )
        }
    }
}