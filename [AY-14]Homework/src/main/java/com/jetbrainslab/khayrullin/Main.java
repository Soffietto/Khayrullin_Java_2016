package com.jetbrainslab.khayrullin;

import com.jetbrainslab.khayrullin.dao.*;
import com.jetbrainslab.khayrullin.entity.*;
import com.jetbrainslab.khayrullin.enums.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static UserDAO userDAO= new UserDAO();
    static NewsDAO newsDAO = new NewsDAO();
    static CommunityDAO communityDAO = new CommunityDAO();
    static MessageDAO messageDAO = new MessageDAO();
    static RequestDAO requestDAO = new RequestDAO();

    public static void main(String[] args) throws SQLException {
        User user;
        Message message;
        Request request;
        Community community;
        News news;

        boolean checker = true;
        String option;
        int report;
        while (checker){
            option = null;
            System.out.println("Выберете опцию " );
            System.out.println("[Добавить пользователя, добавить сообщение, добавить заявку]");
            System.out.println("[Редактировать сообщество, редактировать новость]");
            System.out.println("[Посмотреть отчёт]");
            option = in.nextLine();
            switch (option){
                case "Добавить пользователя":
                    user = new User();
                    addUser(user);
                    break;
                case "Добавить сообщение":
                    message = new Message();
                    addMessage(message);
                    break;
                case "Добавить заявку":
                    request = new Request();
                    addRequest(request);
                    break;
                case "Редактировать сообщество":
                    community = new Community();
                    editCommunity(community);
                    break;
                case "Редактировать новость":
                    news = new News();
                    editNews(news);
                    break;
                case "Посмотреть отчёт":
                    System.out.println("Выберете нужный отчёт");
                    System.out.println("[1 - Суммарное число новостей во всех сообществах, основанных каким-то пользователем]");
                    System.out.println("[2 - Пользовател(ь-и), получивши(й-е) больше всего сообщений за какой-то сезон (зима, весна, лето, осень)]");
                    System.out.println("[3 - Пользовател(ь-и), откликнувши(й-е)ся на наибольшее число заявок, которые были поданы по адресу, содержащему какой-то набор символов]");
                    report = in.nextByte();
                    switch (report){
                        case 1:
                            System.out.println("Введите id нужного пользователя: ");
                            System.out.println(newsDAO.getMessageCountByUser(in.nextInt()));
                            in.nextLine();
                            break;
                        case 2:
                            System.out.println("Введите нужный сезон[SUMMER, WINTER, SPRING, AUTUMN]");
                            in.nextLine();
                            userDAO.getUsersWithMostMessagesOnSeason(in.nextLine());
                            break;
                        case 3:
                            System.out.println("Введите нужный набор символов: ");
                            in.nextLine();
                            userDAO.getUsersWithMostAnswersByAddressPart(in.nextLine());
                            break;
                        default:
                            System.out.println("Неверный номер отчёта!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Неверная опция!");
                    break;
            }
            System.out.println("Хотите продолжить?");
            if(in.nextLine().equals("Нет"))
                checker = false;
        }
    }

    private static void addUser(User user) throws SQLException {
        System.out.println("Введите имя пользователя:");
        user.setName(in.nextLine());
        System.out.println("Введите фамилию:");
        user.setSurname(in.nextLine());
        System.out.println("Введите email: ");
        user.setEmail(in.nextLine());
        System.out.println("Введите пароль: ");
        user.setPassword(in.nextLine());
        System.out.println("Введите роль[ROLE_USER, ROLE_ADMIN]");
        user.setRole(Role.valueOf(in.nextLine()));
        System.out.println("Введите статус пользователя[ACTIVE, BANNED]");
        user.setUserStatus(UserStatus.valueOf(in.nextLine()));
        userDAO.addUser(user);
        System.out.println("Пользователь добавлен");
    }

    private static void addMessage(Message message) throws SQLException{
        System.out.println("Введите текст сообщения: ");
        message.setText(in.nextLine());
        System.out.println("Введите id отправителя: ");
        message.setSenderId(in.nextInt());
        System.out.println("Введите id получателя: ");
        message.setRecipientId(in.nextInt());
        in.nextLine();
        System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]");
        message.setCreatedAt(Timestamp.valueOf(in.nextLine()));
        System.out.println("Введите статус сообщения[READ, NEW]");
        message.setMessageStatus(MessageStatus.valueOf(in.nextLine()));
        messageDAO.addMessage(message);
        System.out.println("Сообщение добавлено");
    }

    private static void addRequest(Request request) throws SQLException{
        System.out.println("Введите id нуждающегося: ");
        request.setNeedyId(in.nextInt());
        System.out.println("Введите id волонтёра: ");
        request.setVolonteerId(in.nextInt());
        in.nextLine();
        System.out.println("Введите адрес: ");
        request.setAddress(in.nextLine());
        System.out.println("Введите широту: ");
        request.setLatitude(in.nextLong());
        System.out.println("Введите долготу: ");
        request.setLongitude(in.nextLong());
        in.nextLine();
        System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]: ");
        request.setCreatedAt(Timestamp.valueOf(in.nextLine()));
        System.out.println("Выберете тип[HOME, MARKET, STREET]");
        request.setServiceType(ServiceType.valueOf(in.nextLine()));
        System.out.println("Введите статус заявки[PENDING, CLOSED, ACTIVE]: ");
        request.setRequestStatus(RequestStatus.valueOf(in.nextLine()));
        requestDAO.addRequest(request);
        System.out.println("Заявка добавлена");
    }

    private static void editCommunity(Community community) throws SQLException{
        System.out.println("Введите новое имя сообщества: ");
        community.setName(in.nextLine());
        System.out.println("Введите новое описание: ");
        community.setDescription(in.nextLine());
        System.out.println("Введите новое id основателя: ");
        community.setFounderID(in.nextInt());
        in.nextLine();
        System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]: ");
        community.setCreatedAt(Timestamp.valueOf(in.nextLine()));
        System.out.println("Введите id сообщества, которое хотите изменить: ");
        communityDAO.editCommunity(community, in.nextInt());
        in.nextLine();
        System.out.println("Сообщество успешно изменено");
    }

    private static void editNews(News news) throws SQLException{
        System.out.println("Введите новый текст новости: ");
        news.setText(in.nextLine());
        System.out.println("Введите новый id сообщества: ");
        news.setCommunityId(in.nextInt());
        System.out.println("Введите новый id автора: ");
        news.setAuthorId(in.nextInt());
        in.nextLine();
        System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]: ");
        news.setCreatedAt(Timestamp.valueOf(in.nextLine()));
        System.out.println("Введите id новости которую хотите изменить: ");
        newsDAO.editNews(news, in.nextInt());
        in.nextLine();
        System.out.println("Новость успешно изменена");
    }
}
