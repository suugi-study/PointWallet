package com.study.point.application.controller;


/***
 * 포인트 적입/차감 API
 * 1. 관리자 수기 적립 기능
 */
@RequestController("/points")
@Sl4j
public class PointController {

    
    @Comment("관리자 수기 적립")
    @PostMapping("/admin/add")
    public void adminAddPoint(@RequestBody ManagePointRequest request) {

    }
    @Comment("포인트 사용")
    @PostMapping("/use")
    public void usePoints(@RequestBody ManagePointRequest request) {

    }


}
