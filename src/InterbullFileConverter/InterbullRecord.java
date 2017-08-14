/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterbullFileConverter;

/**
 *
 * @author njdbi
 */
public class InterbullRecord {
    private final char[] record;
    
    public InterbullRecord(String line){
        record = line.toCharArray();
    }
    
    public boolean Filter(String value, IndexableFields enumTag){
        String field = deCode(enumTag.start, enumTag.length);
        if(enumTag == IndexableFields.NONE)
            return true;
        return field.matches(value);
    }
    
    public String[] deCodeAll(){
        RecordSegments browser = new RecordSegments();
        String[] values = new String[browser.getLength()];
        for(int x = 0; x < browser.getLength(); x++){
            values[x] = deCode(browser.startPoints[x], browser.lengths[x]);
        }
        return values;
    }
    
    public String[] getNames(){
        RecordSegments browser = new RecordSegments();
        return browser.Names;
    }
    
    private String deCode(int start, int length){
        return new String(record, start - 1, length);
    }
    
    private class RecordSegments{
        protected final int[] startPoints = {
            1,4,7,10,13,14,26,56,64,79,83,89,92,95,96,108,123,126,129,130,142,172,
            187,190,193,194,206,236,239,242,243,255,285,300,303,306,307,319,349,352,
            355,356,368,398,413,458,459,475,477,483,489,495,496,498,501,504,506,511,
            514,517,520,522,528,533,539,541,547,552,558,560,565,570,576,578,583,588,
            594,596,601,603,607,609,613,615,619,621,626,628,630,633,636,641,647,650,
            655,661,664,669,675,678,683,689,692,697,703,706,711,717,720,725,731,734,
            739,745,748,753,759,762,767,773,776,781,787,788,794,797,800,803,805,810,
            816,818,824,829,835,837,842,847,853,855,860,865,871,873,878,880,884,886,
            890,892,896,898,903,908,914,916,922,927,933,935,940,945,951,953,958,963,
            969,971,976,978,982,984,988,990,994,996,1001,1006,1012,1014,1020,1025,
            1031,1033,1038,1043,1049,1051,1056,1061,1067,1069,1074,1076,1080,1082,
            1086,1088,1092,1094,1099,1100,1106,1109,1112,1115,1117,1122,1128,1130,
            1135,1136,1142,1147,1153,1155,1160,1165,1171,1173,1178,1183,1189,1191,
            1196,1197,1203,1206,1209,1212,1214,1219,1225,1227,1232,1233,1239,1242,
            1245,1248,1250,1256,1262,1264,1269,1271,1276,1277,1283,1286,1289,1292,
            1294,1299,1305,1307,1312,1317,1323,1325,1330,1335,1341,1343,1348,1353,
            1359,1361,1366,1371,1377,1379,1384,1389,1395,1397,1402,1407,1413,1415,
            1420,1425,1431,1433,1438,1443,1449,1451,1456,1461,1467,1469,1474,1479,
            1485,1487,1492,1497,1503,1505,1510,1515,1521,1523,1528,1533,1539,1541,
            1546,1551,1557,1559,1564,1569,1575,1577,1582,1587,1593,1595,1600,1605,
            1611,1613,1618,1623,1629,1631,1636,1641,1647,1649,1654,1659,1665,1667,
            1672,1677,1683,1685,1690,1695,1701,1703,1708,1713,1719,1721,1726,1731,
            1737,1739,1744,1749,1755,1757,1762,1767,1773,1776,1781,1787,1790,1795,
            1801,1804,1809,1815,1818,1823,1829,1832,1837,1843,1846,1851,1857,1860,
            1865,1871,1874,1879,1885,1888,1893,1899,1902,1907,1913,1914,1920,1923,
            1926,1929,1931,1936,1942,1944,1949,1954,1960,1962,1967,1972,1978,1980,
            1985,1990,1996,1998,2003,2004,2010,2015,2021,2023,2028,2033,2039,2041,
            2046,2051,2057,2059,2064,2065,2071,2076,2082,2084,2089,2094,2100,2102,
            2107,2112,2118,2120,2125,2130,2136,2138,2143,2148,2154,2156,2161,2166,
            2172,2174,2179,2184,2190,2192,2197,2202,2208,2210,2215,2220,2226,2228,
            2233,2238,2244,2246,2251,2256,2262,2264,2269,2274,2280,2282,2287,2288,
            2294,2297,2300,2303,2305,2310,2316,2318,2323,2324,2330,2335,2341,2343,
            2348,2349,2355,2358,2361,2364,2366,2371,2377,2379,2384,2389,2395,2397,
            2402,2407,2413,2415,2420,2425,2431,2433,2438,2443,2449,2451,2456,2461,
            2467,2469,2474,2479,2485,2487,2492,2497,2503,2505,2510,2511,2517,2522,
            2528,2530,2535,2540,2546,2548,2553,2558,2564,2566,2571,2576,2582,2584,
            2589,2594,2600,2602,2607,2612,2618,2620,2625,2630,2636,2638,2643,2648,
            2654,2656,2661,2666,2672,2674,2679,2684,2690,2692,2697,2702,2708,2710,
            2715,2720,2726,2728,2733,2738,2744,2746,2751,2756,2762,2764,2769,2774,
            2780,2782,2787,2788,2794,2797,2800,2803,2805,2810,2816,2818,2823,2824,
            2830,2835,2841,2843,2848,2853,2859,2861,2866,2871,2877,2879,2884,2885,
            2891,2894,2897,2900,2902,2907,2913,2915,2920,2921,2927,2932,2938,2940,
            2945,2946,2952,2957,2963,2965,2970,2975,2981,2983,2988,2993,2999,3001,
            3006,3011,3017,3019,3024,3025,3031,3034,3037,3040,3042,3048,3054,3056,
            3061,3062,3068,3071,3074,3077,3079,3084,3090,3092,3097,3102,3108,3110,
            3115,3120,3126,3128,3133,3138,3144,3146,3151,3156,3162,3164,3169,3174,
            3180,3182,3187,3192,3198,3200,3205,3210,3216,3218,3223,3228,3234,3236,
            3241,3246,3252,3254,3259,3264,3270,3272,3277,3278,3284,3287,3290,3293,
            3295,3300,3306,3308,3313,3314,3320,3325,3331,3333,3338,3343,3349,3351,
            3356,3361,3367,3369,3374,3375,3381,3384,3387,3390,3392,3397,3403,3405,
            3410,3415,3421,3423,3428,3433,3439,3441,3446,3447,3453,3458,3464,3466,
            3471,3476,3482,3484,3489,3494,3500,3502,3507,3512,3518,3520,3525,3530,
            3536,3538,3543,3548,3554,3556,3561,3562,3568,3571,3574,3577,3579,3584,
            3590,3592,3597,3602,3608,3610,3615,3620,3626,3628,3633,3638,3644,3646,
            3651,3656,3662,3664,3669,3674,3680,3682,3687,3692,3698,3700,3705,3706,
            3712,3717,3723,3725,3730,3735,3741,3743,3748,3753,3759,3761,3766,3771,
            3777,3779,3784,3789,3795,3797,3802,3807,3813,3815,3820,3825,3831,3833,
            3838,3843,3849,3851,3856,3861,3867,3869,3874,3879,3885,3887,3892,3897,
            3903,3905,3910,3915,3921,3923,3928,3929,3935,3938,3941,3944,3946,3951,
            3957,3959,3964,3965,3971,3974,3977,3980,3982,3987,3993,3995,4000,4005,
            4011,4013,4018,4023,4029,4031,4036,4037,4043,4046,4049,4052,4054,4059,
            4065,4067,4073,4078,4084,4086,4092,4097,4103,4105,4110,4115,4121,4123,
            4128,4129,4135,4138,4141,4144,4146,4151,4157,4159,4164,4169,4175,4177,
            4182,4187,4193,4195,4200,4205,4211,4213,4218,4223,4229,4231,4236,4237,
            4243,4248,4254,4256,4261,4266,4272,4274,4279,4284,4290,4292,4297,4302,
            4308,4310,4315,4316,4322,4325,4328,4331,4333,4338,4344,4346,4351,4356,
            4362,4364,4369,4370,4376,4381,4387,4389,4394,4399,4405,4407,4412,4417,
            4423,4425,4430,4431,4437,4440,4443,4446,4448,4453,4459,4461,4466,4467,
            4473,4478,4484,4486,4491,4496,4502,4504,4509,4514,4520,4522,4527,4528,
            4534,4537,4540,4543,4545,4550,4556,4558,4563,4568,4574,4576,4581,4586,
            4592,4594,4599,4604,4610,4612,4617,4622,4628,4630,4635,4636,4642,4647,
            4653,4655,4660,4665,4671,4673,4678,4683,4689,4691,4696,4701,4707,4709,
            4714,4719,4725,4727,4732,4737,4743,4745,4750,4755,4761,4763,4768,4773,
            4779,4781,4786,4791,4797,4799,4804,4809,4815,4817,4822,4827,4833,4835,
            4840,4845,4851,4853,4858,4863,4869,4871,4876,4881,4887,4889,4894,4899,
            4905,4907,4912,4913,4919,4922,4925,4928,4930,4935,4941,4943,4948,4949,
            4955,4958,4961,4964,4966,4971,4977,4979,4984,4989,4995,4997,5002,5003
        };
        
        protected final int[] lengths = {
            3,3,3,3,1,12,30,8,15,4,6,3,3,1,12,15,3,3,1,12,30,15,3,3,1,12,30,3,3,1,
            12,30,15,3,3,1,12,30,3,3,1,12,30,15,45,1,16,2,6,6,6,1,2,3,3,2,5,3,3,3,
            2,6,5,6,2,6,5,6,2,5,5,6,2,5,5,6,2,5,2,4,2,4,2,4,2,5,2,2,3,3,5,6,3,5,6,
            3,5,6,3,5,6,3,5,6,3,5,6,3,5,6,3,5,6,3,5,6,3,5,6,3,5,6,1,6,3,3,3,2,5,6,
            2,6,5,6,2,5,5,6,2,5,5,6,2,5,2,4,2,4,2,4,2,5,5,6,2,6,5,6,2,5,5,6,2,5,5,
            6,2,5,2,4,2,4,2,4,2,5,5,6,2,6,5,6,2,5,5,6,2,5,5,6,2,5,2,4,2,4,2,4,2,5,
            1,6,3,3,3,2,5,6,2,5,1,6,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,1,
            6,3,3,3,2,6,6,2,5,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,
            2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,
            6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,
            5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,3,5,6,3,5,6,3,5,6,3,5,6,3,5,6,3,5,
            6,3,5,6,3,5,6,3,5,6,3,5,6,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,
            1,6,5,6,2,5,5,6,2,5,5,6,2,5,1,6,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,
            5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,
            5,6,2,5,1,6,5,6,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,
            5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,
            5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,
            5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,1,6,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,
            5,6,2,5,1,6,5,6,2,5,1,6,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,6,
            6,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,
            2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,1,6,5,6,2,5,5,
            6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,1,6,5,6,2,5,5,6,2,5,
            5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,5,
            6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,
            2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,
            2,5,6,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,6,5,6,
            2,6,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,
            5,1,6,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,1,6,
            5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,1,6,5,6,2,5,5,6,2,5,5,6,2,
            5,1,6,3,3,3,2,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,5,6,2,5,5,6,
            2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,
            6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,5,6,2,5,1,6,3,3,3,2,5,6,2,5,1,6,3,3,3,2,
            5,6,2,5,5,6,2,5,1,6
        };
        
        protected final String[] Names = {
            "Format identifier","Breed of evaluation","Breed of bull","Country of registration of bull","Sex","ID number of bull","Name of bull","Birthdate of bull","Shortname of bull","Ownercode","AI Code of bull",
"Breed of bull","Country of registration of bull","Sex","ID number of bull","Bull identification in EU format","Breed of bull","Country of registration of bull","Sex","ID number of bull","Name of bull",
"Shortname of bull","Breed","Country of 1st registration","Sex (F)","ID number","Name of dam","Breed of bull","Country of registration of bull","Sex","ID number of bull",
"Name of bull","Shortname of bull","Breed","Country of 1st registration","Sex (F)","ID number","Name of maternal dam","Breed of bull","Country of registration of bull","Sex",
"ID number of bull","Name of bull","Shortname of bull","Genetic codes for single genes (maximum 15 codes)","kind_of_bul","dutch breed code","color code","Date of official evaluation (YYYYMM)","Official refbase of the animal","date of first daughter-based production proof",
"empty","Verwantschapsgraad ( in %)","Country providing this information","trait code 'NVI' ","Repeatability/Reliability of NVI (x100)","NVI","trait code 'TDM' ","Country code","Unit of measurement","Genetic merit",
"Effective daughter contribution in this country","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability production evaluation (x100)","Milk yield evaluation (x10)","Number of herds","Number of daughters","Repeatability/Reliability (x100)","Fat yield evaluation (x10)","Number of herds",
"Number of daughters","Repeatability/Reliability (x100)","Protein yield evaluation (x10)","Number of herds","Number of daughters","Repeatability/Reliability (x100)","Lactose yield evaluation (x10)","Repeatability/Reliability (x100)","Fat percentage evaluation (x100)","Repeatability/Reliability (x100)",
"Protein percentage evaluation (x100)","Repeatability/Reliability (x100)","Lactose percentage evaluation (x100)","Repeatability/Reliability (x100)","Inet","Status of bull in this country","Type of proof in this country","Country code of country of test","Percentage of total daughters in country of test","Number of herds with daughters in all countries",
"Number of daughters in all countries","Country code A","Number of herds in country A","Number of daughters in country A","Country code B","Number of herds in country B","Number of daughters in country B","Country code C","Number of herds in country C","Number of daughters in country C",
"Country code D","Number of herds in country D","Number of daughters in country D","Country code E","Number of herds in country E","Number of daughters in country E","Country code F","Number of herds in country F","Number of daughters in country F","Country code G",
"Number of herds in country G","Number of daughters in country G","Country code H","Number of herds in country H","Number of daughters in country H","Country code I","Number of herds in country I","Number of daughters in country I","Country code J","Number of herds in country J",
"Number of daughters in country J","Source of evaluation","Reference base definition","Trait code 'LAC'","Country code","Unit of measurement","Genetic merit","LACTATION 1","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","Milk yield evaluation (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Fat yield evaluation (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Protein yield evaluation (x10)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Lactose yield evaluation (x10)","Repeatability/Reliability of evaluation (x100)","Fat percentage evaluation (x100)","Repeatability/Reliability of evaluation (x100)","Protein percentage evaluation (x100)","Repeatability/Reliability of evaluation (x100)","Lactose percentage evaluation (x100)",
"Repeatability/Reliability of evaluation (x100)","Inet","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Milk yield evaluation (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Fat yield evaluation (x10)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Protein yield evaluation (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Lactose yield evaluation (x10)","Repeatability/Reliability of evaluation (x100)","Fat percentage evaluation (x100)",
"Repeatability/Reliability of evaluation (x100)","Protein percentage evaluation (x100)","Repeatability/Reliability of evaluation (x100)","Lactose percentage evaluation (x100)","Repeatability/Reliability of evaluation (x100)","Inet","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Milk yield evaluation (x10)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Fat yield evaluation (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Protein yield evaluation (x10)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","Lactose yield evaluation (x10)","Repeatability/Reliability of evaluation (x100)","Fat percentage evaluation (x100)","Repeatability/Reliability of evaluation (x100)","Protein percentage evaluation (x100)","Repeatability/Reliability of evaluation (x100)","Lactose percentage evaluation (x10)","Repeatability/Reliability of evaluation (x100)","Inet",
"Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'PER'","Country code","Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Persistency Overall (x100)",
"Source of evaluation","Reference base definition","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Persistency Lactation 1 (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Persistency Lactation 2 (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Persistency Lactation 3 (x100)","Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'RTM'","Country code","Unit of measurement","Genetic merit",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Rate of Maturity (x100)","Source of evaluation","Reference base definition","Trait code 'LON'","Country code","Unit of measurement","Genetic merit",
"Number of daughters in this country","Number of dead daughters in this country","Repeatability/Reliability of evaluation (x100)","National Proof without predictors","Repeatability/Reliability of evaluation (x100)","National Proof with predictors","Source of evaluation","Reference base definition","Trait code 'CNF'","Country code",
"Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Stature (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Chest width (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Body depth (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Angularity (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","Body Condition score (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Rump Angle (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Rump width (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Rear legs rear view (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Rear leg set side view (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","Foot angle (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Locomotion (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Fore udder attachment (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Front teat placement (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Teat length (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","Udder depth (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Rear udder height (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Udder support (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","Rear teat placement (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","FRAME (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","DAIRY STRENGTH (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","UDDER (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","FEET & LEGS(x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","MUSCULARITY (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","FINAL SCORE (x100)","Zeroes: Available for future use","Zeroes: Available for future use",
"Zeroes: Available for future use","Missing value: Available for future use","Zeroes: Available for future use","Zeroes: Available for future use","Zeroes: Available for future use","Missing value: Available for future use","Number of herds with daughters in all countries","Number of daughters in all countries","Country code A","Number of herds in country A",
"Number of daughters in country A","Country code B","Number of herds in country B","Number of daughters in country B","Country code C","Number of herds in country C","Number of daughters in country C","Country code D","Number of herds in country D","Number of daughters in country D",
"Country code E","Number of herds in country E","Number of daughters in country E","Country code F","Number of herds in country F","Number of daughters in country F","Country code G","Number of herds in country G","Number of daughters in country G","Country code H",
"Number of herds in country H","Number of daughters in country H","Country code I","Number of herds in country I","Number of daughters in country I","Country code J","Number of herds in country J","Number of daughters in country J","Source of evaluation","Reference base definition",
"Trait code 'CE '","Country code","Unit of measurement","Genetic merit","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of birth index","BV Birth Index (x100)","Number of herds with offspring in this country","Number of offspring in this country",
"Repeatability/Reliability of calving ease evaluation (x100)","BV Direct calving ease (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Direct gestation length (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Direct birth weight (x100)",
"Source of evaluation for direct calving process","Reference base definition for direct calving process","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal calving ease (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal gestation length (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal birth weight (x100)","Source of evaluation for maternal calving process","Reference base definition for maternal calving process","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Direct calving ease (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Direct gestation length (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Direct birth weight (x100)","Number of herds with offspring in this country","Number of offspring in this country",
"Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal calving ease (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal gestation length (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal birth weight (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Direct calving ease (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Direct gestation length (x100)","Number of herds with offspring in this country","Number of offspring in this country",
"Repeatability/Reliability of calving ease evaluation (x100)","BV Direct birth weight (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal calving ease (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal gestation length (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calving ease evaluation (x100)","BV Maternal birth weight (x100)","Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'WOR'","Country code","Unit of measurement","Genetic merit",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of milking speed evaluation (x100)","BV Milking speed (x100)","Source of evaluation Milking speed","Reference base definition Milking speed","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of temperament evaluation (x100)","BV Temperament (x100)",
"Source of evaluation Temperament","Reference base definition Temperament","Trait code 'FER'","Country code","Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of fertility index (x100)","Fertility index (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Non Return rate 56 days (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval calving to first insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV calving Interval (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval First to Last Insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Conception rate (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Conception rate heifers (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Age first insemination heifers (x100)","Source of evaluation","Reference base definition",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Non Return rate 56 days (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval calving to first insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV calving Interval (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval First to Last Insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Conception rate (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Non Return rate 56 days (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval calving to first insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV calving Interval (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval First to Last Insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Conception rate (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Non Return rate 56 days (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval calving to first insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV calving Interval (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Interval First to Last Insemination (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Conception rate (x100)",
"Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'SCC'","Country code","Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of scs evaluation (x100)","BV Somatic Cell Score (x100)",
"Source of evaluation ","Reference base definition ","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of scs evaluation (x100)","BV Somatic Cell Score Lactation 1 (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of scs evaluation (x100)","BV Somatic Cell Score Lactation 2 (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of scs evaluation (x100)","BV Somatic Cell Score Lactation 3 (x100)","Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'LIV'","Country code","Unit of measurement","Genetic merit",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","Index Livability (x100)","Source of evaluation for direct livability","Reference base definition direct livability","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","Index Maternal livability (x100)",
"Source of evaluation for maternal livability","Reference base definition for maternal livability","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","livability in heifers (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","Maternal livability in heifers (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","livability in cows (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","Maternal livability in cows (x100)","Source of evaluation lactation","Reference base definition lactation",
"Trait code 'WGT'","Country code","Unit of measurement","Genetic merit","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of body weight evaluation (x100)","BV Body weight (x100)","Source of evaluation","Reference base definition",
"Trait code 'MEA'","Country code","Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Beef Merit Index (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV Meat content (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Fat score (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Carcass weight (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Meat content (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Fat score (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV Growth (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Veal color (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Meat content (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Fat score (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Growth (x100)","Source of evaluation","Reference base definition",
"Trait code 'URE'","Country code","Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV overall Urea (x100)","Source of evaluation ","Reference base definition ",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Urea (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Urea (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV Urea (x100)","Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'UDH'","Country code","Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of udder health index (x100)","Udder health index (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Sublinical mastitis (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Clinical mastitis (x100)",
"Source of evaluation","Reference base definition","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Sublinical mastitis (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Clinical mastitis (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Sublinical mastitis (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Clinical mastitis (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV Sublinical mastitis (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Clinical mastitis (x100)","Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'CLW'","Country code",
"Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of claw health index (x100)","Claw health index (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 1: Sole Haemorrhage/ Bevangenheid (SH) (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 2: Digital Dermatitis/ Mortellaro (DD) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 3: Interdigital Dermatitis/ Stinkpoot (IDD) (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV 4: Sole Ulcer/ Zoolzweer (SU) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 5: Interdigital Hyperplasia/ Tyloom (HYP) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 6: White Line Disease/ Wittelijn defect (WLD) (x100)",
"Source of evaluation","Reference base definition","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 1: Sole Haemorrhage/ Bevangenheid (SH) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 2: Digital Dermatitis/ Mortellaro (DD) (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 3: Interdigital Dermatitis/ Stinkpoot (IDD) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 4: Sole Ulcer/ Zoolzweer (SU) (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV 5: Interdigital Hyperplasia/ Tyloom (HYP) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 6: White Line Disease/ Wittelijn defect (WLD) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 1: Sole Haemorrhage/ Bevangenheid (SH) (x100)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 2: Digital Dermatitis/ Mortellaro (DD) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 3: Interdigital Dermatitis/ Stinkpoot (IDD) (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV 4: Sole Ulcer/ Zoolzweer (SU) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 5: Interdigital Hyperplasia/ Tyloom (HYP) (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV 6: White Line Disease/ Wittelijn defect (WLD) (x100)",
"Source of evaluation for lactation BVs","Reference base definition for lactation BVs","Trait code 'BIN'","Country code","Unit of measurement","Genetic merit","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of birth index","BV Birth Index (x100)",
"Source of evaluation for birth index","Reference base definition for birth index","Trait code 'SUR'","Country code","Unit of measurement","Genetic merit","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of calf survival","BV Calf survival day 3-365 (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of survival day 3-14","BV Survival day 3-14 (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of survival day 15-180","BV Survival day 15-180 (x100)","Source of evaluation for calf survival","Reference base definition for calf survival",
"Trait code 'LTP'","Country code","Unit of measurement","Genetic merit","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of lifetime production index","BV Lifetime Production Index","Number of herds with offspring in this country","Number of offspring in this country",
"Repeatability/Reliability of lifetime milk production","BV Lifetime Milk Production","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of lifetime fat production","BV Lifetime Fat Production","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of lifetime protein production","BV Lifetime Protein Production",
"Source of evaluation for lifetime production","Reference base definition for lifetime production","Trait code 'AMS'","Country code","Unit of measurement","Genetic merit","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","BV AMS-Index (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","BV Efficiency milk(x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","BV Interval (x100)","Number of herds with offspring in this country","Number of offspring in this country",
"Repeatability/Reliability of evaluation (x100)","BV habituation (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","BV Efficiency (x100)","Source of evaluation","Reference base definition","Number of herds with offspring in this country","Number of offspring in this country",
"Repeatability/Reliability of evaluation (x100)","BV efficiency milk in heifers (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","BV interval in heifers (x100)","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","BV efficiency milk in cows (x100)",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of evaluation (x100)","BV interval in cows (x100)","Source of evaluation lactation","Reference base definition","Trait code 'DMI'","Country code","Unit of measurement","Genetic merit",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of DMI index (x100)","DMI index without predictors(x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of DMI index (x100)","DMI index with predictors(x100)","Source of evaluation","Reference base definition",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV DMI (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV DMI (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV DMI (x100)","Source of evaluation","Reference base definition","Trait code 'KET'","Country code","Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of ketose index (x100)","Ketose index (x100)","Source of evaluation","Reference base definition","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Ketose (x100)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of evaluation (x100)","BV Ketose (x100)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of evaluation (x100)","BV Ketose (x100)","Source of evaluation","Reference base definition","Trait code 'CAS'","Country code",
"Unit of measurement","Genetic merit","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of caseine index (x100)","Caseine index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of BLG index (x100)","BLG index (x10)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of ALA index (x100)","ALA index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of IGG index (x100)","IGG index (x10)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of BSA index (x100)","BSA index (x10)","Source of evaluation","Reference base definition","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of caseine index (x100)","Caseine index (x10)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of BLG index (x100)","BLG index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of ALA index (x100)","ALA index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of IGG index (x100)","IGG index (x10)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of BSA index (x100)","BSA index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of caseine index (x100)","Caseine index (x10)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of BLG index (x100)","BLG index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of ALA index (x100)","ALA index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of IGG index (x100)","IGG index (x10)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of BSA index (x100)","BSA index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of caseine index (x100)","Caseine index (x10)","Number of herds with daughters in this country","Number of daughters in this country",
"Repeatability/Reliability of BLG index (x100)","BLG index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of ALA index (x100)","ALA index (x10)","Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of IGG index (x100)","IGG index (x10)",
"Number of herds with daughters in this country","Number of daughters in this country","Repeatability/Reliability of BSA index (x100)","BSA index (x10)","Source of evaluation","Reference base definition","Trait code 'ALV'","Country code","Unit of measurement","Genetic merit",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of age of first calving","BV Age of first calving (x100)","Source of evaluation","Reference base definition","Trait code 'BLI'","Country code","Unit of measurement","Genetic merit",
"Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of Better life Efficiency","BV Better Life Efficiency","Number of herds with offspring in this country","Number of offspring in this country","Repeatability/Reliability of Better life Health","BV Better Life Health","Source of evaluation","Reference base definition"
        };
        
        public int getLength(){
            return this.startPoints.length;
        }
    }
}
