package com.git.service.impl;

import com.git.bean.User;
import com.git.dao.UserDAO;
import com.git.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by lixueqin on 2017/9/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserDAO userDAO;

    @Override
    public List<User> findAll() {

        return userDAO.findAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        System.out.println("UserServiceImpl ==== ");
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        this.userDAO.removeUser(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.updateUser(user);

    }

    @Override
    @Transactional
    public User findById(Integer id) {

        User user =  userDAO.findUserById(id);
        return user;
    }

    @Override
    public InputStream getInputStram() {

        //工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        //sheet
        HSSFSheet sheet = wb.createSheet("sheet1");

        HSSFRow row = sheet.createRow(0);

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("序号");


        cell = row.createCell(1);
        cell.setCellValue("姓");

        cell = row.createCell(2);
        cell.setCellValue("名");

        cell = row.createCell(3);

        cell.setCellValue("年龄");

        List<User> list = findAll();
        for(int i=0;i<list.size();i++){
            User user = list.get(i);

            row = sheet.createRow(i+1);

            cell = row.createCell(0);
            cell.setCellValue(i+1);

            cell = row.createCell(1);
            cell.setCellValue(user.getFirstname());

            cell = row.createCell(2);
            cell.setCellValue(user.getLastname());


            cell = row.createCell(3);
            cell.setCellValue(user.getAge());



        }


        File file = new File("/Users/lixueqin/Desktop/test.xls");
        try {

            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
             is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Executors.newSingleThreadExecutor().submit(() ->{
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            file.delete();
            System.out.println("文件已删除-------");

        });
        return is;
    }


}
