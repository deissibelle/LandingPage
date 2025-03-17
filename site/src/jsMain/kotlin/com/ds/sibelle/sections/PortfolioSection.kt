package com.ds.sibelle.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ds.sibelle.components.PortfolioCard
import com.ds.sibelle.components.SectionTitle
import com.ds.sibelle.models.Portfolio
import com.ds.sibelle.models.Section
import com.ds.sibelle.styles.PortfolioArrowIconStyle
import com.ds.sibelle.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun PortfolioSection() {
    Box(
        modifier = Modifier
            .id(Section.Portfolio.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px),
            section = Section.Portfolio
        )
        PortfolioCards(breakpoint = breakpoint)
        PortfolioNavigation()
    }
}

@Composable
fun PortfolioCards(breakpoint: Breakpoint) {
    val scrollableContainerId = "scrollableContainer"
    val scrollAmount = 325.0 // Adjust this value based on your card width + margin
    val isAtEnd = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .id(scrollableContainerId)
            .fillMaxWidth()
            .margin(bottom = 25.px)
            .maxWidth(
                if (breakpoint > Breakpoint.MD) 950.px
                else if (breakpoint > Breakpoint.SM) 625.px
                else 300.px
            )
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth) // Smooth scrolling
            .transition(Transition.of(property = "scroll-left", duration = 2000.ms)) // Slower scroll transition
    ) {
        Portfolio.entries.forEach { portfolio ->
            PortfolioCard(
                modifier = Modifier.margin(
                    right = if (portfolio != Portfolio.Five) 25.px else 0.px
                ),
                portfolio = portfolio
            )
        }
    }

    // Auto-scroll logic
    LaunchedEffect(Unit) {
        while (true) {
            delay(10000) // 10 seconds delay

            val container = document.getElementById(scrollableContainerId)
            if (container != null) {
                val currentScroll = container.scrollLeft
                val maxScroll = container.scrollWidth - container.clientWidth

                if (currentScroll >= maxScroll - 1) {
                    // If at the end, reset to the start
                    container.scrollTo(x = 0.0, y = 0.0)
                    isAtEnd.value = false
                } else {
                    // Otherwise, scroll to the next card
                    container.scrollBy(x = scrollAmount, y = 0.0)
                }
            }
        }
    }
}

@Composable
fun PortfolioNavigation() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        FaArrowLeft(
            modifier = PortfolioArrowIconStyle.toModifier()
                .margin(right = 40.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById("scrollableContainer")
                        ?.scrollBy(x = (-325.0), y = 0.0)
                },
            size = IconSize.LG
        )
        FaArrowRight(
            modifier = PortfolioArrowIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById("scrollableContainer")
                        ?.scrollBy(x = 325.0, y = 0.0)
                },
            size = IconSize.LG
        )
    }
}