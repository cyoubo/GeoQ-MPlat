package com.geoq.arcserver.admin.message.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentInfo {
   private String Title;
   private String Author;
   private String Comments;
   private String Subject;
   private String Category;
   private String AntialiasingMode;
   private String TextAntialiasingMode;
   private String Keywords;
}
