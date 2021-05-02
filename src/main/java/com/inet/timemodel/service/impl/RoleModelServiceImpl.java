package com.inet.timemodel.service.impl;

import com.inet.timemodel.dao.RoleModelDao;
import com.inet.timemodel.dao.impl.RoleModelDaoImpl;
import com.inet.timemodel.domain.RoleModel;
import com.inet.timemodel.service.RoleModelService;

import java.util.List;

public class RoleModelServiceImpl implements RoleModelService {

    /**
     * 获取时代楷模
     *
     * @return java.util.List<com.inet.timemodel.domain.RoleModel>
     * @author HCY
     * @since 2021/3/18 下午2:20
     */
    @Override
    public List<RoleModel> getRoleModel() {
        //创建roleModelDao持久层
        RoleModelDao roleModelDao = new RoleModelDaoImpl();
        return roleModelDao.getRoleModel();
    }
}
