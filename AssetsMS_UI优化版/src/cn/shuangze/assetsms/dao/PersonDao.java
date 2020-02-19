
package cn.shuangze.assetsms.dao;
import cn.shuangze.assetsms.entity.Person;
/**
 *
 * @author yuanshuai
 */
public interface PersonDao {
    int add(Person person) throws Exception;//添加人员
    int delete(int personID) throws Exception;//按编号删除
    int modify(Person person)throws Exception;//修改人员
    Person findByPersonID(int personID)throws Exception;
    String [][] findAll() throws Exception;  
    
}
