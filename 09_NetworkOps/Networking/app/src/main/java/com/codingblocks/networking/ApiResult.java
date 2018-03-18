package com.codingblocks.networking;

import java.util.ArrayList;

/**
 * Created by harshitdwivedi on 17/03/18.
 */

public class ApiResult {

    private Integer total_count;
    private Boolean incomplete_results;
    private ArrayList<GithubUser> items;

    public ApiResult() {
    }

    public ApiResult(Integer total_count, Boolean incomplete_results, ArrayList<GithubUser> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(Boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public ArrayList<GithubUser> getItems() {
        return items;
    }

    public void setItems(ArrayList<GithubUser> items) {
        this.items = items;
    }
}
