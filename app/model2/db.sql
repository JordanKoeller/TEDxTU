
CREATE TABLE event (
    id SERIAL NOT NULL,
    title varchar(1000) NOT NULL,
    subtitle varchar(1000),
    description text NOT NULL,
    venue varchar(1000) NOT NULL,
    event_date date NOT NULL,
    time time NOT NULL,
    max_seats int NOT NULL,
    taken_seats int NOT NULL,
    registration_link varchar(1000) NOT NULL,
    media_link varchar(1000),
    PRIMARY KEY (id)
);

CREATE TABLE posters (
    id SERIAL NOT NULL,
    name varchar(100) NOT NULL,
    email varchar(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE newsletter_post (
    id SERIAL NOT NULL,
    post_date date NOT NULL,
    description text NOT NULL,
    user_id int NOT NULL,
    title varchar(1000) NOT NULL,
    subtitle varchar(1000) NOT NULL,
    abstract varchar(1000) NOT NULL,
    media_link varchar(1000),
    PRIMARY KEY (id)
);

CREATE TABLE speakers (
    speaker_id SERIAL NOT NULL,
    event_id int NOT NULL,
    name varchar(1000) NOT NULL,
    bio text NOT NULL,
    media varchar(1000) NOT NULL,
    PRIMARY KEY (speaker_id)
);

CREATE TABLE team_member (
    id SERIAL NOT NULL,
    is_active int NOT NULL,
    name varchar(1000) NOT NULL,
    position varchar(1000) NOT NULL,
    major varchar(1000) NOT NULL,
    grad_class int NOT NULL,
    biography text NOT NULL,
    email varchar(1000) NOT NULL,
    media_url varchar(1000) NOT NULL,
    PRIMARY KEY (id)
);


