package com.example.composetask.presentation.dashboard

sealed class DashboardIntent {
    data class OnCardClick(val position: Int) : DashboardIntent()
}