package org.eleks.api.trello.http_clients;

import org.eleks.api.trello.models.responses.GetAllListsOnBoard.GetAllListResponseItem;

import java.util.List;

public class GetAllListHttpClient extends BoardHttpClient {
/*This method deserialize Array JSON into the list of the JSON object
* */
    public List<GetAllListResponseItem> getAllListsFromBoard (String boardId){

        List<GetAllListResponseItem> listResponses = BaseHttpClient.createRequestSpecification()
                .get(PATH + boardId+"/lists")
                .then()
                .log()
                .all()
                .extract()
                .body().jsonPath().getList(".",GetAllListResponseItem.class)
                ;
        return listResponses;
    }
//    public GetAllListResponse getAllListsFromBoard (String boardId){
//            return BaseHttpClient.createRequestSpecification()
//                    .get(PATH + boardId+"/lists")
//                    .then()
//                    .log()
//                    .all()
//                    .extract()
//                    .as(GetAllListResponse.class)
//                    ;
//    }
}
