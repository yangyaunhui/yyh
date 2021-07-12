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
    public void checkPwd(String cardid, String cardPwd) {
        CustomerData customerData = CustomerData.getInstance();
        customerList = customerData.getCustomerList();
        // 1. 拿到  carid中的账户名 和 cardPwd  对  list中的数据做对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)) {
                // 拿出来这个人
                currentCustomer = customer;
                // 账户正确
                System.out.println("欢迎" + customer.getCname() + "顾客登录!请注意您的安全");
                TextUtil.oneLeveOption(); //界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
                // 如何 保证 按了 1 3 5... 让他再此回到 此界面呢 ?
            }
        }
    }

    private void oneOption(String option) {

        switch (option) {
            case "1":
                System.out.println("余额查询");

                // 查询余额外
                doSelectMoney();
                // 当按下1 之后,  回退到  1及选项
                goOneHome();
                break;
            case "2":
               goGetMoneyHome();
                goOneHome();
                break;
            case "3":
                doTuranMoney();
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
        System.out.println(" 余额是 " + money);
    }

    //转账
    private void doTuranMoney() {
        System.out.println("请输入您要转账的卡号：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入您要转账的金额：");
        String otherMoney = scanner.nextLine();
        //做计算  自己的钱 - otherMoney ,别人的钱加上 + otherMoney
        //自己减钱
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double customerMoney = currentCustomer.getMoney() - otherMoneyInt;//自己被 减去转账的 钱
        //别人加钱，根据otherAccount 本人的账户查询出 别人的余额，查询出别人的余额后，修改别人的余额
        //因为所有人都在customerList 这个集合中
        Customer other = null;
        for (Customer customer : customerList) {
            //如果 customer.getAcount 等于 otherAccount 那么这个人就被选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other=customer;
            }
        }
        double otherOneMoney = other.getMoney() + otherMoneyInt; //别人的余额

        //自己和别人都跟新一下钱数
        currentCustomer.setMoney(customerMoney);
        other.setMoney(otherOneMoney); //注意：有问题？不能够创建对象了

        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }


    //存款
    private void saveMoney() {
        System.out.println("请输入您的存款金额：");
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();
        if (currentCustomer != null) {
            if (money > 0) {
                currentCustomer.setMoney(currentCustomer.getMoney() + money);
                System.out.println("存款成功");
                System.out.println("你的当前余额为：" + currentCustomer.getMoney());
            } else {
                System.out.println("输入错误");
            }

        }
    }

    //取卡
    private void goOneHome() {
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);  // 递归算法
    }

    //取款
    private void goGetMoneyHome() {
        TextUtil.getMoneyUI();
        //1.让客户输入
        Scanner scanner = new Scanner(System.in);
        String numIn = scanner.nextLine();
        if (numIn.equals("1")) {
            //那么 取款100 那么就应该 让顾客的钱减100
            double money = currentCustomer.getMoney();
            money = money - 100;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("2")){
            //那么 取款200 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 200;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("3")){
            //那么 取款300 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 300;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("4")){
            //那么 取款400 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 400;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("5")){
            //那么 取款800 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 800;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("6")){
            //那么 取款1000 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 1000;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("7")){
            //那么 取款2000 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 2000;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("8")){
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
    }
}


