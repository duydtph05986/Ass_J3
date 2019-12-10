Create database ASS
go
use ASS
go


Create table USERS
(
Taikhoan nVARCHAR(40) not null,
Matkhau nvarchar(20),
vaitro nvarchar(30)
Constraint pk_users primary key(Taikhoan)
)


create table Students
(
Masv nvarchar(50) not null,
Hoten nvarchar(50),
Email nvarchar(50),
SoDT nvarchar(15),
Gioitinh nvarchar(3),
Diachi nvarchar(50),
Hinh nvarchar(50)

constraint pk_Students primary key(Masv)
)

create table Grade
(
ID int Identity(1,1000),
Masv nvarchar(50),
Tienganh float,
Tinhoc float,
GDTC float
constraint pk_Grade primary key(ID)
Constraint fk_grade_student foreign key (Masv) references Students (Masv)
)


--du lieu bang users
insert into USERS values('giangvien1', 'matkhau', 'giang vien')
insert into USERS values('giangvien2', 'matkhau', 'giang vien')
insert into USERS values('admin', 'matkhau', 'can bo dao tao')

---du lieu bang Student
insert into Students values('PH01234','Nguyen Van Nam','Namnv@gmail.com','01234875755','Nam', 'Ha noi', 'namnv.jpg')
insert into Students values('PH01235','Hoang Minh Thu','ThuHM@gmail.com','0952556515','Nu', 'Quang Ninh', 'thuhm.jpg')
insert into Students values('PH01236','Le Dang Khoa','khoald@gmail.com','09545555454','Nam', 'Ha noi', 'khoald.jpg')
insert into Students values('PH01237','Tran Thi Trang','Trangtt@gmail.com','0188514546','Nu', 'Lang Son', 'trangtt.jpg')
insert into Students values('PH01238','Dao Manh Hieu','Hieudm@gmail.com','09546564556','Nam', 'Quang Nam', 'hieudm.jpg')
insert into Students values('PH01239','Nguyen Ngoc Minh','Minhnn@gmail.com','0185454515','Nu', 'Ha noi', 'minhnn.jpg')

--- du lieu bang grade

insert into Grade values('PH01234', 6,7.5,9)
insert into Grade values('PH01235', 10,10,8)
insert into Grade values('PH01236', 2,3,5)
insert into Grade values('PH01237', 1,10,9)
insert into Grade values('PH01238', 8,8,9)
insert into Grade values('PH01239', 10,10,10)


select * from users
select * from Students
select * from grade

select top 3 Students.masv, hoten , tienganh, tinhoc,gdtc, 
sum((tienganh+tinhoc+gdtc)/3) 
as diemtb from grade join students 
on grade.masv=students.masv 
group by Students.masv, hoten,tienganh,tinhoc,gdtc order by diemtb desc

update grade set Tienganh=1, tinhoc=1, gdtc=1 where Masv='ph01234'


