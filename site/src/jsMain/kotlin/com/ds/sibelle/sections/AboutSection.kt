package com.ds.sibelle.sections

import androidx.compose.runtime.Composable
import com.ds.sibelle.components.SectionTitle
import com.ds.sibelle.components.Skillbar
import com.ds.sibelle.models.Section
import com.ds.sibelle.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.px

@Composable
fun AboutSection(){
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding (topBottom = 150.px),
        contentAlignment = Alignment.Center
    ) {
  SectionTitle(section = Section.About,
      alignment = Alignment.End
  )

    }
}