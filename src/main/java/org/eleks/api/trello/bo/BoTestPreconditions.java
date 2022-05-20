package org.eleks.api.trello.bo;

import org.eleks.api.trello.bo.board.BoardBO2;

public class BoTestPreconditions extends BoardBO2 {
//todo fix naming

    public static CardBO createCardPreconditions() {
        return new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                ;
    }

    public static ListBO createListPreconditions() {
        return new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                ;
    }

    public static CardAttachmentBO createCardWithAttachmentPreconditions() {
        return new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .initCardBO()
                .initCardAttachmentBO()
                .addAttachmentToCard();
    }

    public static CardAttachmentBO createCardChecklistChecklistItemsAttachmentPreconditions() {
        return new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .addChecklistItemsAndCheck()
                .initCardBO()
                .initCardAttachmentBO()
                .addAttachmentToCard();
    }
}
