CREATE TABLE Companies
(
    CompanyName VARCHAR(100),
    Revenue     BIGINT,
    Employees   INT
);

INSERT INTO Companies (CompanyName, Revenue, Employees)
VALUES ('TechCorp', 1000000, 100),
       ('InnovateLtd', 500000, 50),
       ('AlphaInc', 700000, 75),
       ('BetaLLC', 200000, 30);

WITH CompanyStats AS (SELECT CompanyName,
                             Revenue,
                             Employees,
                             CAST(Revenue AS FLOAT) / Employees AS RevenuePerEmployee
                      FROM Companies
                      WHERE Employees >= 50)
SELECT *
FROM CompanyStats;

WITH CompanyStats AS (SELECT CompanyName,
                             Revenue,
                             Employees,
                             CAST(Revenue AS FLOAT) / Employees AS RevenuePerEmployee
                      FROM Companies
                      WHERE Employees >= 50)
SELECT *
FROM CompanyStats
ORDER BY RevenuePerEmployee DESC LIMIT 1;