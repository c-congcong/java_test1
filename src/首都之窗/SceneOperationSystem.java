package beijing;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

libs 首都之窗;

/**
 * 场景化-业务系统
 * @author liupan
 * @since 2019-03-27
 */
@TableName("scene_operation_system")
public class SceneOperationSystem  implements Serializable {

    private static final long serialVersionUID = -1864922734014517384L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 显示名称(系统名称)
     */
    private String name;

    /**
     * 所有标签是否展示
     */
    private Integer displayAll = 1;

    /**
     * 生效范围，多值保存
     */
    private String tabName;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 状态 -1删除,0停用,1正常,-2疑似死链
     */
    private int status=1;

    /**
     * 详情页面
     */
    private String url;

    /**
     * 所属站点
     */
    private String siteCode;

    /**
     * 一网通查id (多个用 英文逗号 隔开)
     */
    private String searchGroupIds="";

    /**
     * 查询标签,完全匹配，数据保存时，多个标签使用逗号分割
     */
    private String tags;

    /**
     * 简介
     */
    private String memo;
    /**
     * 标准LOGO
     */
    private String standardImg;
    /**
     * 相关展示LOGO
     */
    private String relatedImg;
    /**
     * 分组备注
     */
    private String groupMemo;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 最后修改时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastModify;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDisplayAll() {
        return displayAll;
    }

    public void setDisplayAll(Integer displayAll) {
        this.displayAll = displayAll;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getStandardImg() {
        return standardImg;
    }

    public void setStandardImg(String standardImg) {
        this.standardImg = standardImg;
    }

    public String getRelatedImg() {
        return relatedImg;
    }

    public void setRelatedImg(String relatedImg) {
        this.relatedImg = relatedImg;
    }

    public String getGroupMemo() {
        return groupMemo;
    }

    public void setGroupMemo(String groupMemo) {
        this.groupMemo = groupMemo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSearchGroupIds() {
        return searchGroupIds;
    }

    public void setSearchGroupIds(String searchGroupIds) {
        this.searchGroupIds = searchGroupIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
