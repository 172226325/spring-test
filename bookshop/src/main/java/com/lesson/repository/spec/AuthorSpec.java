/**
 * 
 */
package com.lesson.repository.spec;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;

import com.lesson.domain.Author;
import com.lesson.dto.AuthorCondition;
import com.lesson.repository.spec.support.QueryWraper;
import com.lesson.repository.spec.support.ShopSimpleSpecification;

/**
 * @author zhailiang
 *
 */
public class AuthorSpec extends ShopSimpleSpecification<Author, AuthorCondition> {

	public AuthorSpec(AuthorCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<Author> queryWraper) {
//		addLikeCondition(queryWraper, "name");

		//如果name不为空
		if(StringUtils.isNotBlank(getCondition().getName())) {
			//按name模糊查询
			Predicate nameLike = createLikeCondition(queryWraper, "name", getCondition().getName());
			//按email模糊查询
			Predicate emailLike = createLikeCondition(queryWraper, "email", getCondition().getName());
			//两个条件之间是 or
			queryWraper.addPredicate(queryWraper.getCb().or(nameLike, emailLike));
		}
		//年龄查询的是区间数据
		addBetweenCondition(queryWraper, "age");
		//查询某性别的数据
		addEqualsCondition(queryWraper, "sex");

		//添加非页面传递来的查询条件
		addEqualsConditionToColumn(queryWraper, "enable", true);
	}
	
	@Override
	protected void addFetch(Root<Author> root) {
		root.fetch("books", JoinType.LEFT);
	}
	
	

}
