create database QuanLyGame;
use QuanLyGame;

create table StoreAdmin(
	GID nvarchar(20) primary key,
	Game nvarchar(50),
	GiaGame float,
	NPH nvarchar(20),
	TheLoai nvarchar(50),
	GamePic nvarchar(50),
	ThongTin nvarchar(100),
	
);
create table StoreUser_Lib(
	IDGame nvarchar(20) primary key,
	Game nvarchar(50),
	GiaGame float,
	NPH nvarchar(20),
	TheLoai nvarchar(50),
	GamePic nvarchar(50),
	ThongTin nvarchar(100),
	constraint fk_su_sta foreign key(IDGame) references StoreAdmin(GID) on delete cascade
);
create table UserLibrary(
	GameID nvarchar(20) primary key,
	Game nvarchar(50),
	GiaGame float,
	NPH nvarchar(20),
	TheLoai nvarchar(50),
	GamePic nvarchar(50),
	ThongTin nvarchar(100),
	
	constraint fk_su_lib foreign key(GameID) references StoreUser_Lib(IDGame) 
);
create table ThongKePhanHoi(
	IDS nvarchar(20) primary key,
	Game nvarchar(50),
	GiaGame float,
	TheLoai nvarchar(50),
	DanhGia nvarchar(100),
	Likes bit
	--constraint fk_tk_user foreign key(IDS) references UserLibrary(GameID) --NORIN
);
create table ThongKePhanHoi(
	IDS nvarchar(20) primary key,
	Game nvarchar(50),
	GiaGame float,
	TheLoai nvarchar(50),
	DanhGia nvarchar(100),
	Likes bit
	--constraint fk_tk_user foreign key(IDS) references UserLibrary(GameID) --NORIN
);
create table ThongKeHoanTra(
	IDS nvarchar(20) primary key,
	Game nvarchar(50),
	GiaGame float,
	--constraint fk_tk_user foreign key(IDS) references UserLibrary(GameID) --NORIN
);

CREATE TABLE ACCCOUNT(
	USERNAME VARCHAR (20),
	GMAIL NCHAR(50),
	PASS CHAR(20),
	CONFIRM CHAR(20),
	MONEYY float,
	CONSTRAINT PK_US PRIMARY KEY (USERNAME),
)




create trigger addtwotb
on StoreAdmin for insert
as declare @IDGame nvarchar(20),
	@Game nvarchar(50),
	@GiaGame float,
	@NPH nvarchar(20),
	@TheLoai nvarchar(50),
	@GamePic nvarchar(50),
	@ThongTin nvarchar(100);

	select @IDGame = GID from inserted ;
	select @Game = Game from inserted;
	select @GiaGame = GiaGame from inserted;
	select @NPH = NPH from inserted ;
	select @TheLoai = TheLoai from inserted;
	select @GamePic = GamePic from inserted;
	select @ThongTin = ThongTin from inserted;

	insert into StoreUser_Lib(IDGame,Game,GiaGame,NPH,TheLoai,GamePic,ThongTin)values
	(@IDGame,@Game,@GiaGame,@NPH,@TheLoai,@GamePic,@ThongTin);
	------------------------------

	create trigger addtklib
on UserLibrary for insert
as declare @IDGame nvarchar(20),
	@Game nvarchar(50),
	@GiaGame float,
	@NPH nvarchar(20),
	@TheLoai nvarchar(50)
	

	select @IDGame = GameID from inserted ;
	select @Game = Game from inserted;
	select @GiaGame = GiaGame from inserted;

	select @TheLoai = TheLoai from inserted;
	
	

	insert into ThongKePhanHoi(IDS,Game,GiaGame,TheLoai)values
	(@IDGame,@Game,@GiaGame,@TheLoai);
	-----------
	create trigger deltklib
on UserLibrary for delete
as declare @IDGame nvarchar(20),
	@Game nvarchar(50),
	@GiaGame float
	

	select @IDGame = GameID from deleted ;
	select @Game = Game from deleted;
	select @GiaGame = GiaGame from deleted;

	
	
	

	insert into ThongKeHoanTra(IDS,Game,GiaGame)values
	(@IDGame,@Game,@GiaGame);
	-------------------


	select * from ThongKeHoanTra
	insert into StoreAdmin(GID) values ('nullpoint')
	insert into UserLibrary(GameID)values
	('3123')
	select * from StoreUser_Lib
	delete from StoreAdmin where GID = '11'
	select * from StoreAdmin
	select sum(GiaGame) from ThongKePhanHoi


	select * from UserLibrary

	select * from ThongKePhanHoi
	select distinct TheLoai from StoreUser_Lib
	insert into StoreAdmin values('1','1','1','1','1','1','1')

	select count(*) from StoreUser_Lib

	delete  from UserLibrary
	select * from ACCCOUNT
	update ACCCOUNT set MONEYY = MONEYY + 10600 where USERNAME = '1111'