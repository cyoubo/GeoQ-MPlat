package com.geoq.arcserver.admin.message;

import com.geoq.arcserver.admin.message.element.Error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseMessage {
    protected Error error;
}
