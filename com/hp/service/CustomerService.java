package com.hp.service;


import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TextUtil;


import java.util.List;
import java.util.Scanner;

public class CustomerService {
    //CustomerData customerData = CustomerData.getInstance();
    //List<Customer> customerList = customerData.getCustomerList();
    private List<Customer> customerList;
    private Customer currentCustomer;

    // 1. 查, 登录 判断账号密码是否正确
    public void  checkPwd(String cardid, String  cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        customerList  = customerData.getCustomerList();
        // 1. 拿到  carid中的账户名 和 cardPwd  对  list中的数据做对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                // 拿出来这个人
                currentCustomer=  customer;
                // 账户正确
                System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全"   );
                TextUtil.oneLeveOption(); //界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
                // 如何 保证 按了 1 3 5... 让他再此回到 此界面呢 ?
            }
        }
    }

    private void oneOption(String option) {

        switch (option){
            case "1":
                System.out.println("余额查询");

                // 查询余额外
                doSelectMoney();
                // 当按下1 之后,  回退到  1及选项
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                withdrawMoney();
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                Money();
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                saveMoney();
                goOneHome();
                break;
            case "5":
                System.out.println("退卡成功，欢迎下次使用");

                System.exit(0);

        }
    }
    // 查询余额
    private void doSelectMoney() {
        double money = currentCustomer.getMoney();
        System.out.println(" 余额是 " +money);
    }
    //取款
    private void withdrawMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的取款金额：");
        int money = sc.nextInt();
        if (money>0&&money<=currentCustomer.getMoney()){
            currentCustomer.setMoney(currentCustomer.getMoney()-money);
            System.out.println("取款成功");
            System.out.println("你的当前余额为："+currentCustomer.getMoney());
        }else {
            System.out.println("输入错误");
        }
    }
    //转账
    private void Money() {
        System.out.println("请输入您要转账的卡号：");
        Scanner account = new Scanner(System.in);
        int money = account.nextInt();
        Customer nuser = null;
        boolean IsExit = false;
    }




    //存款
    private void saveMoney(){
        System.out.println("请输入您的存款金额：");
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();
        if (currentCustomer!=null){
            if (money>0){
                currentCustomer.setMoney(currentCustomer.getMoney()+money);
                System.out.println("存款成功");
                System.out.println("你的当前余额为："+currentCustomer.getMoney());
            }else{
                System.out.println("输入错误");
            }

        }
    }
    //取卡


    private  void goOneHome( ){
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);  // 递归算法
    }

}


