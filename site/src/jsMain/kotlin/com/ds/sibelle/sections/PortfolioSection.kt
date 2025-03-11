package com.ds.sibelle.sections

import androidx.compose.runtime.Composable
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
fun PortfolioSection(){

    Box(
        modifier = Modifier
            .id(Section.Portfolio.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding (topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ServiceContent()

    }
}