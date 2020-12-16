package com.mikehenry.springbootjpabeginner.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InQueryRequest {

    List<String> firstNames;
}
