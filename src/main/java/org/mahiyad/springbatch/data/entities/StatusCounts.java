package org.mahiyad.springbatch.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class StatusCounts {
    private String status;
    private Long count;
}
