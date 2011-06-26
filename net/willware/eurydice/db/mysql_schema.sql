use eurydice;

create table `structures` (
  `id` int(11) NOT NULL auto_increment,
  `uuid` varchar(40) NOT NULL,
  `parentUuid` varchar(40) default NULL,
  `metadata` varchar(5000) default NULL,
  UNIQUE(`id`),
  UNIQUE(`uuid`)
);

create table `atoms` (
  `id` int(11) NOT NULL,
  `structureId` int(11) NOT NULL,
  `element` varchar(2) NOT NULL,
  `hybridization` varchar(4) NOT NULL,
  -- electric charge???
  `x` double NOT NULL,
  `y` double NOT NULL,
  `z` double NOT NULL,
  UNIQUE(`id`, `structureId`)
);

create table `jigs` (
  `id` int(11) NOT NULL,
  `structureId` int(11) NOT NULL,
  `jigtype` varchar(60) NOT NULL,
  `properties` varchar(1000) default NULL,
  UNIQUE(`id`, `structureId`)
);
