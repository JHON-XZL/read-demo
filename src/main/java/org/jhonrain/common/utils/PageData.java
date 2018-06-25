package org.jhonrain.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * <p>功能描述</br>分页类</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 15:01
 */
public class PageData implements Serializable {

  private static final long serialVersionUID = 1L;
  //总记录数
  private int totalCount;
  //每页记录数
  private int pageSize;
  //总页数
  private int totalPage;
  //当前页数
  private int currPage;
  //列表数据
  private List<?> list;

  /**
   * 分页
   *
   * @param list       列表数据
   * @param totalCount 总记录数
   * @param pageSize   每页记录数
   * @param currPage   当前页数
   */
  public PageData(List<?> list, int totalCount, int pageSize, int currPage) {
    this.list = list;
    this.totalCount = totalCount;
    this.pageSize = pageSize;
    this.currPage = currPage;
    this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getCurrPage() {
    return currPage;
  }

  public void setCurrPage(int currPage) {
    this.currPage = currPage;
  }

  public List<?> getList() {
    return list;
  }

  public void setList(List<?> list) {
    this.list = list;
  }

}
