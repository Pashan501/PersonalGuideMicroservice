create table if not exists places (
                                      id serial,
                                      title varchar(100) not null,
                                      description varchar(255) not null,
                                      imageSources varchar(255) not null,
                                      texts varchar(255) not null,
                                      primary key (id)
);

create table if not exists foods (
                                     id serial,
                                     title varchar(100) not null,
                                     description varchar(255) not null,
                                     imageSources varchar(255) not null,
                                     texts varchar(255) not null,
                                     primary key (id)
);

create table if not exists routes (
                                      id serial,
                                      title varchar(100) not null,
                                      description varchar(255) not null,
                                      texts varchar(255) not null,
                                      primary key (id)
);

/*Places database*/
INSERT  INTO  places (id,title, description, imageSources, texts)
VALUES (1,'personalguide.place.title.1',
        'personalguide.place.description.1',
        'https://personalguidebucket.s3.us-east-2.amazonaws.com/sofia_title.jpeg&&https://personalguidebucket.s3.us-east-2.amazonaws.com/sofia2.jpeg',
        'personalguide.place.text.1.1&&personalguide.place.text.1.2')
ON CONFLICT (id) DO NOTHING ;

INSERT  INTO  places (id,title, description, imageSources, texts)
VALUES (2,'personalguide.place.title.2',
        'personalguide.place.description.2',
        'https://personalguidebucket.s3.us-east-2.amazonaws.com/lavra.jpeg&&https://personalguidebucket.s3.us-east-2.amazonaws.com/lavra2.jpeg',
        'personalguide.place.text.2.1&&personalguide.place.text.2.2')
ON CONFLICT (id) DO NOTHING ;

INSERT  INTO  places (id,title, description, imageSources, texts)
VALUES (3,'personalguide.place.title.3',
        'personalguide.place.description.3',
        'https://personalguidebucket.s3.us-east-2.amazonaws.com/vladimir.jpeg&&https://personalguidebucket.s3.us-east-2.amazonaws.com/vladimir2.jpeg',
        'personalguide.place.text.3.1&&personalguide.place.text.3.2')
ON CONFLICT (id) DO NOTHING ;

INSERT  INTO  places (id,title, description, imageSources, texts)
VALUES (4,'personalguide.place.title.4',
        'personalguide.place.description.4',
        'https://personalguidebucket.s3.us-east-2.amazonaws.com/goldengate.jpeg&&https://personalguidebucket.s3.us-east-2.amazonaws.com/goldengate2.jpeg',
        'personalguide.place.text.4.1&&personalguide.place.text.4.2')
ON CONFLICT (id) DO NOTHING ;

/*Foods database*/
INSERT  INTO  foods (id,title, description, imageSources, texts)
VALUES (1,'personalguide.food.title.1',
        'personalguide.food.description.1',
        'https://personalguidebucket.s3.us-east-2.amazonaws.com/ParPar.jpeg&&https://personalguidebucket.s3.us-east-2.amazonaws.com/ParPar2.jpeg',
        'personalguide.food.text.1.1&&personalguide.food.text.1.2')
ON CONFLICT (id) DO NOTHING ;

INSERT  INTO  foods (id,title, description, imageSources, texts)
VALUES (2,'personalguide.food.title.2',
        'personalguide.food.description.2',
        'https://personalguidebucket.s3.us-east-2.amazonaws.com/sanpaolo1.jpeg&&https://personalguidebucket.s3.us-east-2.amazonaws.com/sanpaolo2.jpeg',
        'personalguide.food.text.2.1&&personalguide.food.text.2.2')
ON CONFLICT (id) DO NOTHING ;

INSERT  INTO  foods (id,title, description, imageSources, texts)
VALUES (3,'personalguide.food.title.3',
        'personalguide.food.description.3',
        'https://personalguidebucket.s3.us-east-2.amazonaws.com/guramma-restaurant.jpeg&&https://personalguidebucket.s3.us-east-2.amazonaws.com/guramma-restaurant2.jpeg',
        'personalguide.food.text.3.1&&personalguide.food.text.3.2')
ON CONFLICT (id) DO NOTHING ;

/*Routes database*/
INSERT  INTO  routes (id,title, description,texts)
VALUES (1,'personalguide.rout.title.1',
        'personalguide.rout.description.1',
        'personalguide.rout.text.1.1&&personalguide.rout.text.1.2')
ON CONFLICT (id) DO NOTHING ;

INSERT  INTO  routes (id,title, description, texts)
VALUES (2,'personalguide.rout.title.2',
        'personalguide.rout.description.2',
        'personalguide.rout.text.2.1&&personalguide.rout.text.2.2')
ON CONFLICT (id) DO NOTHING ;

INSERT  INTO  routes (id,title, description, texts)
VALUES (3,'personalguide.rout.title.3',
        'personalguide.rout.description.3',
        'personalguide.rout.text.3.1&&personalguide.rout.text.3.2')
ON CONFLICT (id) DO NOTHING ;
