--Sheer Fiol, Ayman Wehbi

SELECT DISTINCT PHYSICIAN_NAME
FROM PHYSICIAN INNER JOIN TIMECARD
ON PHYSICIAN.PHYSICIAN_ID = TIMECARD.PHYSICIAN_ID
WHERE SPECIALTY = 'Dermatology'
AND (SELECT SUM(HOURS) from TIMECARD 
                    WHERE PHYSICIAN.PHYSICIAN_ID = TIMECARD.PHYSICIAN_ID) > 22;

SELECT SPECIALTY, SUM(HOURS), COUNT(*)
FROM PHYSICIAN I INNER JOIN TIMECARD O
ON I.PHYSICIAN_ID = O.PHYSICIAN_ID
GROUP BY SPECIALTY;

SELECT O.NURSE_NAME
FROM NURSE I INNER JOIN NURSE O
ON I.NURSE_ID = O.SUPERVISOR_ID
WHERE I.NURSE_NAME = 'Chris Summa';

SELECT DISTINCT NURSE_NAME
FROM NURSE I INNER JOIN BED O
ON I.NURSE_ID = O.NURSE_ID;

SELECT NURSE_NAME
FROM NURSE I LEFT OUTER JOIN BED O
on I.NURSE_ID = O.NURSE_ID
WHERE O.NURSE_ID is null
GROUP BY NURSE_NAME;

SELECT NURSE_NAME
FROM NURSE 
WHERE SUPERVISOR_ID = 'N01';

SELECT SPECIALTY, COUNT(*)
FROM PHYSICIAN I INNER JOIN PATIENT O
ON I.PHYSICIAN_ID = O.PHYSICIAN_ID
Group BY SPECIALTY;

SELECT AVG(NURSE_SALARY)
FROM NURSE I INNER JOIN BED O
ON I.NURSE_ID = O. NURSE_ID
HAVING COUNT(*) > 1;

SELECT PATIENT_NAME
FROM PATIENT I INNER JOIN BED O
ON I.PATIENT_NUMBER = O.PATIENT_NUMBER
INNER JOIN NURSE P
ON O.NURSE_ID = P.NURSE_ID
WHERE NURSE_SALARY = (SELECT MIN(NURSE_SALARY) FROM NURSE);

SELECT AVG(PATIENT_AGE)
FROM PATIENT I INNER JOIN BED O
On I.PATIENT_NUMBER = O.PATIENT_NUMBER;