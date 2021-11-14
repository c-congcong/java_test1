package beijing;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * 置顶实体类
 */

@TableName("topinfo")
public class TopInfo implements Serializable {

    private static final long serialVersionUID = -1045383651998781564L;

    @TableId(value = "id",type = IdType.UUID)
	private String id;

    /**
     * 配置名称
     */
    private String name;

	/**
	 * 显示类别 TODO ： 0纯图片模式,1 模拟数据信息
	 */
	private Integer type = 0;


	/**
	 * 状态 -1删除,0停用,1正常,-2疑似死链
	 */
	private Integer status = 1;

	/**
	 * 所属站点
	 */
	private String siteCode;
	/**
	 * 一网通查id (多个用 英文逗号 隔开)
	 */
	private String searchGroupIds;
	/**
	 * 全部标签是否展示
	 */
	private Integer displayAll = 1;
	/**
	 * 生效范围，多值保存
	 */
	private String tabName;
	/**
	 *  搜索词
	 */
	private String words;
	/**
	 * 排序
	 */
	private Integer rank = 10;
	/**
	 * 图片(720*120)
	 */
	private String imgPath;

	/**
	 * url
	 */
	private String url;
	/**
	 * 数据配置[标签名称|标题|摘要|站点|时间]
	 * 图片及url使用标准字段存储
	 */
	private String json;

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
	 * 最后更新时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date lastModify;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGroupMemo() {
		return groupMemo;
	}

	public void setGroupMemo(String groupMemo) {
		this.groupMemo = groupMemo;
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

	public Integer getDisplayAll() {
		return displayAll;
	}

	public void setDisplayAll(Integer displayAll) {
		this.displayAll = displayAll;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public boolean analogDoc(){
		return Objects.nonNull(type) && 1 == type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TopInfo topInfo = (TopInfo) o;
		return Objects.equals(id, topInfo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
