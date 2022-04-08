package com.contoso.inventory

import com.contoso.inventory.command.RequestForCreatingProductCommand
import com.contoso.inventory.command.RequestForUpdatingProductCommand

data class RequestForApprovalDto(
    val kind: Kind,
    val creatingProductCommand: RequestForCreatingProductCommand?,
    val updatingProductCommand: RequestForUpdatingProductCommand?,
) {
    enum class Kind {
        CreatingProduct,
        UpdatingProduct,
    }

    companion object {
        fun getExamples(): List<RequestForApprovalDto> = listOf(
            RequestForApprovalDto(
                kind = Kind.CreatingProduct,
                creatingProductCommand = RequestForCreatingProductCommand.getExamples().random(),
                updatingProductCommand = null,
            ),
            RequestForApprovalDto(
                kind = Kind.UpdatingProduct,
                creatingProductCommand = null,
                updatingProductCommand = RequestForUpdatingProductCommand.getExamples().random(),
            ),
        )
    }
}
