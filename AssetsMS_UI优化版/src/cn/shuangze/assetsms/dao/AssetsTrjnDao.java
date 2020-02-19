package cn.shuangze.assetsms.dao;
import cn.shuangze.assetsms.entity.AssetsTrjn;
import java.util.List;
/**
 *
 * @author yuanshuai
 */
public interface AssetsTrjnDao {
    int add(AssetsTrjn assetsTrjn) throws Exception;
    int delete(int jourNo) throws Exception;
    int modify(AssetsTrjn assetsTrjn)throws Exception;
    List<AssetsTrjn> findByFromAcc(String bType) throws Exception;
    String [][] findAll() throws Exception;
    int[] findAssetsID() throws Exception;
    int[] findPersonID() throws Exception;
    List<AssetsTrjn> findByPerson(int personid) throws Exception;
    List<AssetsTrjn> findByAssets(int assetsid) throws Exception;
}
