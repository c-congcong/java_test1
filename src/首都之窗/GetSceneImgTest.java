//package beijing;
//
////import com.alibaba.druid.pool.DruidDataSource;
////import com.alibaba.fastjson.JSONObject;
////import com.toptime.esm.domain.SceneSubject;
////import com.toptime.esm.util.CommonUtils;
////import org.springframework.jdbc.core.BeanPropertyRowMapper;
////import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.io.*;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//
//
///**
// * @author : haiyang
// * @description :
// * @date : create in 2021/10/19 16:13
// */
//public class GetSceneImgTest {
//
//
//    private final static String SITECODE="1100000041";
//
//    private final static String dirPathImg="D:\\WorkSpace\\首都之窗\\img";
//
//    private final static String dirPathZip="D:\\WorkSpace\\首都之窗";
//
//
//
//
//    private final static String imgPre = "http://192.141.252.157:8090/";
//
//    public static void main(String[] args) {
//        img();
//    }
//
//
//    private static void img(){
//        JdbcTemplate jdbcTemplate = null;
//        try {
//            jdbcTemplate = new JdbcTemplate(createDataSource());
//
//            //业务系统
//            List<JSONObject> systemScene = systemScene(jdbcTemplate);
//
//            //场景主题
//            List<JSONObject> subjectScene = subjectScene(jdbcTemplate);
//
//            //置顶信息
//            List<JSONObject> topinfoImgs = topinfoImgs(jdbcTemplate);
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("业务系统",systemScene);
//            jsonObject.put("场景主题",subjectScene);
//            jsonObject.put("置顶信息",topinfoImgs);
//            //写文件到json
//            writeJson(jsonObject);
//
//            //压缩
//            compressToZip(dirPathImg,dirPathZip,"场景化相关图片.zip");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    /**
//     * 获取业务系统的图片信息
//     * @param jdbcTemplate
//     * @return
//     */
//    private static List<JSONObject> systemScene(JdbcTemplate jdbcTemplate){
//        ArrayList<JSONObject> arrayList = new ArrayList<>();
//        String sql = "select id,`name`,standardImg,relatedImg,url from scene_operation_system where siteCode = "+SITECODE+" and status in (1,-2) ";
//        List<SceneOperationSystem> systemList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SceneOperationSystem>(SceneOperationSystem.class));
//
//        for (SceneOperationSystem operationSystem : systemList) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("id",operationSystem.getId());
//            jsonObject.put("name",operationSystem.getName());
//            jsonObject.put("url",operationSystem.getUrl());
//            //获取standardImg
//            if (CommonUtils.nonEmpty(operationSystem.getStandardImg())){
//                jsonObject.put("standardImg",imgPre+operationSystem.getStandardImg());
//
//                downloadImg(imgPre+operationSystem.getStandardImg());
//
//            }
//            //获取 relatedImg
//            if (CommonUtils.nonEmpty(operationSystem.getRelatedImg())){
//                jsonObject.put("relatedImg",imgPre+operationSystem.getRelatedImg());
//
//                downloadImg(imgPre+operationSystem.getRelatedImg());
//
//            }
//            arrayList.add(jsonObject);
//        }
//
//        return  arrayList;
//
//    }
//
//
//    /**
//     * 场景主题
//     * @param jdbcTemplate
//     * @return
//     */
//    private static List<JSONObject> subjectScene(JdbcTemplate jdbcTemplate){
//        ArrayList<JSONObject> arrayList = new ArrayList<>();
//        List<SceneSubject> sceneSubjects = jdbcTemplate.query("select `name`,id,configJson from scene_subject where siteCode="+SITECODE+"  and status in (1,-2)",new BeanPropertyRowMapper<SceneSubject>( SceneSubject.class));
//        for (SceneSubject sceneSubject : sceneSubjects) {
//            String configJson = sceneSubject.getConfigJson();
//            if (CommonUtils.nonEmpty(configJson)){
//                JSONObject jsonObject = new JSONObject();
//                SceneSubject.SubjectConfig config = JSONObject.parseObject(configJson, SceneSubject.SubjectConfig.class);
//                List<SceneSubject.SubjectPicInfo> subjectPicInfoList = config.getSubjectPicInfoList();
//                if (!subjectPicInfoList.isEmpty()){
//                    ArrayList<JSONObject> imgList = new ArrayList<>();
//                    for (SceneSubject.SubjectPicInfo subjectPicInfo : subjectPicInfoList) {
//                        if (CommonUtils.nonEmpty(subjectPicInfo.getImgUrl())){
//                            JSONObject temp = new JSONObject();
//                            temp.put("url",subjectPicInfo.getUrl());
//                            temp.put("imgUrl",imgPre+subjectPicInfo.getImgUrl());
//
//                            downloadImg(imgPre+subjectPicInfo.getImgUrl());
//
//                            imgList.add(temp);
//                        }
//                    }
//                    jsonObject.put("imgUrl",imgList);
//
//                    jsonObject.put("name",sceneSubject.getName());
//                    jsonObject.put("id",sceneSubject.getId());
//                    arrayList.add(jsonObject);
//                }else {
//                    System.out.println(sceneSubject.getName()+"图片信息列表为空,id"+sceneSubject.getId());
//                }
//            }else {
//                System.out.println(sceneSubject.getName()+"configJson为空,id"+sceneSubject.getId());
//            }
//
//        }
//
//        return arrayList;
//    }
//
//
//    /**
//     * 置顶信息
//     * @param jdbcTemplate
//     * @return
//     */
//    public static List<JSONObject> topinfoImgs(JdbcTemplate jdbcTemplate){
//        ArrayList<JSONObject> arrayList = new ArrayList<>();
//        List<TopInfo> topInfos = jdbcTemplate.query("select  id,`name`,imgPath,url  from topinfo where siteCode="+SITECODE+" and status in (1,-2)", new BeanPropertyRowMapper<TopInfo>(TopInfo.class));
//
//        for (TopInfo topInfo : topInfos) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("name",topInfo.getName());
//            jsonObject.put("id",topInfo.getId());
//            jsonObject.put("url",topInfo.getUrl());
//            if (CommonUtils.nonEmpty(topInfo.getImgPath())){
//                jsonObject.put("imgPath",imgPre+topInfo.getImgPath());
//
//                downloadImg(imgPre+topInfo.getImgPath());
//
//            }
//            arrayList.add(jsonObject);
//        }
//
//        return arrayList;
//    }
//
//
//
//
//    //获取链接
//    private static DruidDataSource createDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl("jdbc:mariadb://39.107.59.211:3306/tempsdzcesm?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=UTC");
//        druidDataSource.setPassword("topadmin");
//        druidDataSource.setUsername("Top123!@#");
//        druidDataSource.setDriverClassName("org.mariadb.jdbc.Driver");
//        // 连接获取失败，快速退出，避免一直尝试获取连接，死循环
//        druidDataSource.setFailFast(true);
//
//        return druidDataSource;
//    }
//
//
//    /**
//     * 压缩文件
//     *
//     * @param sourceFilePath 源文件路径
//     * @param zipFilePath    压缩后文件存储路径
//     * @param zipFilename    压缩文件名
//     */
//    public static void compressToZip(String sourceFilePath, String zipFilePath, String zipFilename) {
//        File sourceFile = new File(sourceFilePath);
//        File zipPath = new File(zipFilePath);
//        if (!zipPath.exists()) {
//            zipPath.mkdirs();
//        }
//        File zipFile = new File(zipPath + File.separator + zipFilename);
//        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
//            writeZip(sourceFile, "", zos);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage(), e.getCause());
//        }
//    }
//
//
//    private static void downloadImg(String imgUrl){
//        downloadImg(imgUrl,dirPathImg);
//    }
//
//    /**
//     * 遍历所有文件，压缩
//     *
//     * @param file       源文件目录
//     * @param parentPath 压缩文件目录
//     * @param zos        文件流
//     */
//    public static void writeZip(File file, String parentPath, ZipOutputStream zos) {
//        if (file.isDirectory()) {
//            //目录
//            parentPath += file.getName() + File.separator;
//            File[] files = file.listFiles();
//            for (File f : files) {
//                writeZip(f, parentPath, zos);
//            }
//        } else {
//            //文件
//            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
//                //指定zip文件夹
//                ZipEntry zipEntry = new ZipEntry(parentPath + file.getName());
//                zos.putNextEntry(zipEntry);
//                int len;
//                byte[] buffer = new byte[1024 * 10];
//                while ((len = bis.read(buffer, 0, buffer.length)) != -1) {
//                    zos.write(buffer, 0, len);
//                    zos.flush();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new RuntimeException(e.getMessage(), e.getCause());
//            }
//        }
//
//    }
//
//
//    /**
//     * 将图片下载到本地
//     * @param imgUrl
//     * @param dirPath
//     */
//    private static void downloadImg(String imgUrl,String dirPath){
//       try {
//           URL url1 = new URL(imgUrl);
//           URLConnection uc = url1.openConnection();
//           InputStream inputStream = uc.getInputStream();
//           String[] split = imgUrl.split("/");
//           FileOutputStream out = new FileOutputStream(dirPath+"\\"+split[split.length-1]);
//           int j = 0;
//           while ((j = inputStream.read()) != -1) {
//               out.write(j);
//           }
//           inputStream.close();
//       }catch (Exception e){
//           e.printStackTrace();
//       }
//    }
//
//
//    /**
//     * 将json写入文件
//     * @param jsonObject
//     */
//    private static void writeJson(JSONObject jsonObject){
//        try {
//            String fileName = "D:\\WorkSpace\\首都之窗\\imgList.json";
//            File file = new File(fileName);
//            if (file.exists()){
//                file.delete();
//            }
//            file.createNewFile();
//
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
//            bufferedWriter.write(jsonObject.toJSONString());
//            bufferedWriter.flush();
//            bufferedWriter.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//}
