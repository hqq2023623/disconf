package com.baidu.disconf2.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.disconf2.client.config.ConfigMgr;
import com.baidu.disconf2.client.config.inner.DisClientConfig;
import com.baidu.disconf2.client.core.DisconfCoreMgr;
import com.baidu.disconf2.client.fetcher.inner.restful.RestfulMgr;
import com.baidu.disconf2.client.scan.ScanMgr;

/**
 * 
 * Disconf Client 总入口
 * 
 * @author liaoqiqi
 * @version 2014-5-23
 */
public class DisconfMgr {

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(DisconfMgr.class);

    // 本实例不能初始化两次
    private static boolean isInit = false;

    /**
     * 
     * @param scanPackage
     */
    public static void run(String scanPackage) {

        // 该函数不能调用两次
        if (isInit == true) {
            LOGGER.info("DisConfMgr has been init, ignore........");
            return;
        }

        //
        //
        //

        LOGGER.info("================================= DISCONF START ======================================");

        try {

            // 导入配置
            ConfigMgr.init();

            // 是否开启远程配置
            if (DisClientConfig.getInstance().ENABLE_REMOTE_CONF == false) {
                LOGGER.info("Use Local Configuration.");
                return;
            }

            // 初始化下载器
            RestfulMgr.getInstance().init();

            // 扫描并入库
            LOGGER.info("start to scan package: " + scanPackage);
            ScanMgr.scanAndStore(scanPackage);

            // 获取数据/注入/Watch
            DisconfCoreMgr.run();

        } catch (Exception e) {

            LOGGER.error(e.toString());
        }

        LOGGER.info("================================= DISCONF END ======================================");
    }

    /**
     * 
     * @Description: 总关闭
     * 
     * @return void
     * @author liaoqiqi
     * @date 2013-6-14
     */
    public static void close() throws Exception {

        try {

            // RestfulMgr
            LOGGER.info("=============== RestfulMgr close =================");
            RestfulMgr.getInstance().close();

            // close, 必须将其设置为False,以便重新更新
            isInit = false;

        } catch (Exception e) {

            LOGGER.error("DisConfMgr close Failed.", e);
            throw new Exception("DisConfMgr close Failed.", e);
        }
    }

}