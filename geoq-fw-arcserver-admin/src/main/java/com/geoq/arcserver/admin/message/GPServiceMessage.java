package com.geoq.arcserver.admin.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GPServiceMessage extends BaseMessage{
    private double currentVersion;
    private String serviceDescription;
    private List<String> tasks;
    private String executionType;
    private String resultMapServerName;
    private int maximumRecords;
}
