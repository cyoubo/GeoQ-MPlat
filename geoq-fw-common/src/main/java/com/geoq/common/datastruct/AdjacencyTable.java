package com.geoq.common.datastruct;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AdjacencyTable {

    private List<? extends AdjacencyTableElement> elements;

    public void loadData(List<? extends AdjacencyTableElement> tableElements)
    {
        elements = new ArrayList<>(tableElements);
    }

    public List<AdjacencyTableElement> trackBack2root(AdjacencyTableElement start_node)
    {
        List<AdjacencyTableElement> results = new ArrayList<>();
        results.add(start_node);
        trackBack2root(start_node,results);
        return results;
    }

    private void trackBack2root(AdjacencyTableElement node, List<AdjacencyTableElement> list)
    {
        if(node.getParentKey() != node.getSelfKey())
            for (AdjacencyTableElement element : elements)
            {
                if(element.getParentKey() == node.getSelfKey())
                {
                    list.add(element);
                    trackBack2root(element,list);
                }
            }
    }

    public void release() {
        if(elements!=null)
            elements.clear();
        elements = null;
    }
}
