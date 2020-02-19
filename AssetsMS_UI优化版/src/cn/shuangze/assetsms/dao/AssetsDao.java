
package cn.shuangze.assetsms.dao;
import cn.shuangze.assetsms.entity.Assets;
import cn.shuangze.assetsms.entity.AssetsType;
import java.util.List;

/**
 *
 * @author yuanshuai
 */
public interface AssetsDao {
     int add(Assets assets) throws Exception;//增加资产信息
     int delete(int id) throws Exception;//删除资产信息
    int modify(Assets assets)throws Exception;//修改资产信息
    Assets findByAssetsID(int assetsID)throws Exception;//通过资产编号查找资产信息
    int[] findTypeID() throws Exception;//通过资产类别表中的编号查询资产信息
   String [][] findAll() throws Exception;//查询所有资产信息   
   String[][] findByStatus(String status) throws Exception ;
   List<Assets> findByTypeID(int TypeID) throws Exception;
   String[][] findBynotStatus(String status) throws Exception;
}
