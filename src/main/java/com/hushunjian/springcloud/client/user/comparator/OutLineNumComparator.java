package com.hushunjian.springcloud.client.user.comparator;

import com.hushunjian.springcloud.client.user.response.TreeResponse;
import org.apache.commons.lang.StringUtils;

import java.util.Comparator;

public class OutLineNumComparator implements Comparator<TreeResponse> {
    @Override
    public int compare(TreeResponse o1, TreeResponse o2) {
        int compare = o1.getOutLineNum().compareTo(o2.getOutLineNum());
        if (StringUtils.equals(o1.getParentOutLineNum(), o2.getParentOutLineNum())){
            compare = o1.getOrderNum() - o2.getOrderNum();
        }
        return compare;
    }
}
