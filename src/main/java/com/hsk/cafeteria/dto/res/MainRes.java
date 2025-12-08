package com.hsk.cafeteria.dto.res;

import lombok.*;

import java.util.List;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainRes {


    private List<CafeteriaRes> cafeteria;
    private List<MenuRes> menu;
}
