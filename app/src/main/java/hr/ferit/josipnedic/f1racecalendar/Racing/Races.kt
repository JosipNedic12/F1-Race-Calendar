package hr.ferit.josipnedic.f1racecalendar.Racing
/*

val races = listOf(
    F1Race(
        id = 1,
        image= "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Bahrein.jpg?alt=media&token=4e179f18-d97c-483f-af6b-3a5a11384d28",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/bahreinlay.png?alt=media&token=398f9843-3dad-49e1-a4cd-4a50adfd71fb",
        name = "Formula 1 Gulf air Bahrain Grand Prix",
        date ="February 29.",
        location = "Bahrain",
        training1Time = "February 29. 12:30 Friday",
        training2Time = "February 29. 16:00 Friday",
        training3Time = "March 1. 13:30 Saturday",
        qualyTime ="March 1. 17:00 Saturday",
        raceTime = "March 2. 16:00 Sunday"
    ),
    F1Race(
        id = 2,
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Saudi.jpg?alt=media&token=d1d4d440-abc8-41be-96eb-532ce78fad28",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/saudilay.png?alt=media&token=22da57dd-f6ef-4455-bfd9-bf2803a41353",
        name = "Formula 1 STC Saudi Arabian Grand Prix",
        date ="March 7.",
        location = "Saudi Arabia",
        training1Time = "March 7. 14:30 Friday",
        training2Time = "March 7. 18:00 Friday",
        training3Time = "March 8. 14:30 Saturday",
        qualyTime = "March 8. 18:00 Saturday",
        raceTime = "March 9. 18:00 Sunday"
),
    F1Race(
        id = 3,
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/australia.jpg?alt=media&token=c8614c04-feea-4407-9a60-886211873efb",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/australialay.png?alt=media&token=c73198ff-ee8c-4df0-b5b8-54a0ac735e0e",
        name = "Formula 1 Rolex Australian Grand Prix",
        date ="March 22.",
        location = "Australia",
        training1Time = "March 22. 2:30 Friday",
        training2Time = "March 22. 6:00 Friday",
        training3Time = "March 23. 2:30 Saturday",
        qualyTime = "March 23. 6:00 Saturday",
        raceTime = "March 22. 5:00 Sunday"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/japan.jpg?alt=media&token=03fb9ed9-2c70-4c0a-8d25-4893d45b6641",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/japanlay.png?alt=media&token=e1a93ca1-c206-4245-b49d-cc7ae5de66b5",
        id = 4,
        name = "Formula 1 MSC cruises Japanese Grand Prix",
        date ="April 5.",
        location = "Japan",
        training1Time = "April 5. 4:30 Friday",
        training2Time = "April 5. 8:00 Friday",
        training3Time = "April 6. 4:30 Saturday",
        qualyTime = "April 6. 8:00 Saturday",
        raceTime = "April 7. 7:00 Sunday"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/kina.png?alt=media&token=f23ebe6c-8afb-4ba6-9667-10672eb87292",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/chinalay.png?alt=media&token=5013c333-e990-483a-8a24-a5b0c2a8ad1b",
        id = 5,
        name = "Formula 1 Lenovo Chinese Grand Prix",
        date ="April 19.",
        location = "China",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Miami.jpg?alt=media&token=5497bcb7-2cd2-4c92-a6df-02775936c8dd",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/miamilay.png?alt=media&token=38809960-af0f-4163-9732-cd0d828255dd",
        id = 6,
        name = "Formula 1 Crypto.com Miami Grand Prix",
        date ="May 3.",
        location = "United States",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Imola.jpg?alt=media&token=f3c6c326-921e-4d46-b1d5-1cc6fd8e3b33",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/imolalay.png?alt=media&token=e2f5b219-5e00-4cd1-bdea-a8c2b7b6f5e3",
        id = 7,
        name = "Formula 1 MSC cruises Gran Premio Delle'Emilia-Romagna",
        date ="May 17.",
        location = "Italy",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Monaco.jpg?alt=media&token=fecc513f-4e16-48b3-b447-5f41318efa24",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/monacolay.png?alt=media&token=4fbe84ef-4c1a-47b2-a464-142ccec8328d",
        id = 8,
        name = "Formula 1 Grand Prix De Monaco",
        date ="May 24.",
        location = "Monaco",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Canada.jpg?alt=media&token=bc260cad-cb28-4d6e-a86e-cfd37d9bc2ab",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/canadalay.png?alt=media&token=c92dacc0-3603-4558-a4fc-a148611db19d",
        id = 9,
        name = "Formula 1 Grand Prix Du Canada",
        date ="June 7.",
        location = "Canada",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Barcelona.jpg?alt=media&token=05ad1c3d-3cfc-477c-9c6b-8005af2f69ba",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/spainlay.png?alt=media&token=2a303334-ef45-4e17-bb7f-dc41cf6ae908",
        id = 10,
        name = "Formula 1 Aramco Gran Premio De España",
        date ="June 21.",
        location = "Spain",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Austria.jpg?alt=media&token=be29095b-7ac1-4577-b3ab-7a26cf0f5ace",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/austrialay.png?alt=media&token=03e90cd2-4de9-4f07-96fc-31db95200081",
        id = 11,
        name = "Formula 1 Qatar Airways Austrian Grand Prix",
        date ="June 28.",
        location = "Austria",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Great%20Britain.jpg?alt=media&token=0bba618e-3ee7-43c7-a276-db0603868501",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/greatbritainlay.png?alt=media&token=56d993a6-38ed-4195-a23c-d6b80ade3d97",
        id = 12,
        name = "Formula 1 Qatar Airways British Grand Prix",
        date ="July 5.",
        location = "Great Britain",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Hungary.jpg?alt=media&token=e11fe046-8952-43fa-989e-ec857ec8ddbe",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/hungarylay.png?alt=media&token=441eb5e2-aa7a-47dc-91a3-d0546df26867",
        id = 13,
        name = "Formula 1 Hungarian Grand Prix",
        date ="July 19.",
        location = "Hungary",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Belgium.jpg?alt=media&token=5e40aa65-bee0-4ff0-a1d4-f3be099ef35b",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/belgiumlay.png?alt=media&token=8d76d31d-add5-41f5-ac45-a48a4cfac387",
        id = 14,
        name = "Formula 1 Rolex Belgian Grand Prix",
        date ="July 26.",
        location = "Belgium",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Netherlands.png?alt=media&token=b12bd27b-afb9-47e2-a8f6-5e9e2c0672fb",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/netherlandslay.png?alt=media&token=8f32764a-4676-4deb-9814-9dc21a1305ee",
        id = 15,
        name = "Formula 1 Heineken Dutch Grand Prix",
        date ="August 23.",
        location = "Netherlands",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Monza.jpg?alt=media&token=6b56a82c-3eeb-4ab0-8ff5-cbe5242545d0",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/monzalay.png?alt=media&token=848db551-6fa2-471b-b940-5a076ebb3cf5",
        id = 16,
        name = "Formula 1 Pirelli Gran Premio D'Italia",
        date ="August 30.",
        location = "Italy",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Azerbaijan.jpg?alt=media&token=915786d9-a11b-44b5-8227-1647b15ff11a",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/azerbaijanlay.png?alt=media&token=406b4ab2-e039-401d-93a1-c407ae38b1b7",
        id = 17,
        name = "Formula 1 Qatar Airways Azerbaijan Grand Prix",
        date ="September 13.",
        location = "Azerbaijan",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Singapore.jpg?alt=media&token=9679a5e9-71fa-4cfd-a47f-b7063dd698f7",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/singaporelay.png?alt=media&token=7db925a9-c11d-4c2f-9861-e83bc7fb4593",
        id = 18,
        name = "Formula 1 Singapore Airlines Singapore Grand Prix",
        date ="September 22.",
        location = "Singapore",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Usa.jpg?alt=media&token=3be4b600-6c2d-4bb9-9c42-01923f1479b4",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/usalay.png?alt=media&token=4d02be3b-11dd-4261-925e-7ae0b595fb28",
        id = 19,
        name = "Formula 1 Pirelli United States Grand Prix",
        date ="October 18.",
        location = "United States",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Mexico.png?alt=media&token=50da0846-7468-485d-8485-bcce3b34ea1a",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/mexicolay.png?alt=media&token=e6564b97-4755-4fe4-bc00-e96aacfeef31",
        id = 20,
        name = "Formula 1 Gran Premio De La Ciudad De Mexico",
        date ="October 25.",
        location = "Mexico",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Brazil.jpg?alt=media&token=9d8fb1c1-1af4-433c-aa2c-248aa047e7a7",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/brazillay.png?alt=media&token=d932dadd-24b2-4944-b1f0-9db841cce9fc",
        id = 21,
        name = "Formula 1 Lenovo Grande Premio De Sao Paulo",
        date ="November 1.",
        location = "Brazil",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Las%20vegas.jpg?alt=media&token=43b76d9f-9830-4764-a4f6-d704a2fd5098",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/lasvegaslay.png?alt=media&token=c147819b-a4a0-4689-aa3b-77e736f5df25",
        id = 22,
        name = "Formula 1 Heineken Silver Las Vegas Grand Prix",
        date ="November 21.",
        location = "United States",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/Qatar.jpg?alt=media&token=1d55e5b0-4c90-4221-a975-d5797aea3cca",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/qatarlay.png?alt=media&token=f78201ea-87b3-420a-b8f8-762cc9035e8d",
        id = 23,
        name = "Formula 1 Qatar Airways Qatar Grand Prix",
        date ="November 29.",
        location = "Qatar",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    ),
    F1Race(
        image="https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/AbuDhabi.jpg?alt=media&token=b570138b-f2ea-4e42-90ad-21d45868bf2b",
        layout = "https://firebasestorage.googleapis.com/v0/b/f1racecalendar.appspot.com/o/abudhabilay.png?alt=media&token=60911e0c-13a4-4582-8cc4-7fc1f233b741",
        id = 24,
        name = "Formula 1 Etihad Airways Abu Dhabi Grand Prix",
        date ="December 6.",
        location = "Abu Dhabi",
        training1Time = "TBC",
        training2Time = "TBC",
        training3Time = "TBC",
        qualyTime = "TBC",
        raceTime = "TBC"
    )
)

*/




