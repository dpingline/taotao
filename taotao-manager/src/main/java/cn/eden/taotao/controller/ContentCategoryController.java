package cn.eden.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.eden.taotao.pojo.TreeNode;
import cn.eden.taotao.service.ContentCategoryService;
import cn.eden.taotao.util.TaotaoResult;

/**
 * 商品分类管理
 * 
 * @author Eden
 *
 */
@Controller
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	List<TreeNode> getCategoryList(
			@RequestParam(value = "id", defaultValue = "0") long parentId) {
		return contentCategoryService.getCategoryList(parentId);
	}

	@RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
	@ResponseBody
	TaotaoResult insertContentCategory(Long parentId, String name) {
		return contentCategoryService.insertContentCategory(parentId, name);
	}
}
