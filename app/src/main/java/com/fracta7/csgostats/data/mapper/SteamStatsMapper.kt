package com.fracta7.csgostats.data.mapper

import com.fracta7.csgostats.data.local.SteamStatsEntity
import com.fracta7.csgostats.domain.model.PlayerStatsJSON
import com.fracta7.csgostats.domain.model.SteamStats

fun SteamStatsEntity.toSteamStats(): SteamStats {
    return SteamStats(
        total_kills = total_kills,
        total_deaths = total_deaths,
        total_time_played = total_time_played,
        total_planted_bombs = total_planted_bombs,
        total_defused_bombs = total_defused_bombs,
        total_wins = total_wins,
        total_damage_done = total_damage_done,
        total_money_earned = total_money_earned,
        total_rescued_hostages = total_rescued_hostages,
        total_kills_knife = total_kills_knife,
        total_kills_hegrenade = total_kills_hegrenade,
        total_kills_glock = total_kills_glock,
        total_kills_deagle = total_kills_deagle,
        total_kills_elite = total_kills_elite,
        total_kills_fiveseven = total_kills_fiveseven,
        total_kills_xm1014 = total_kills_xm1014,
        total_kills_mac10 = total_kills_mac10,
        total_kills_ump45 = total_kills_ump45,
        total_kills_p90 = total_kills_p90,
        total_kills_awp = total_kills_awp,
        total_kills_ak47 = total_kills_ak47,
        total_kills_aug = total_kills_aug,
        total_kills_famas = total_kills_famas,
        total_kills_g3sg1 = total_kills_g3sg1,
        total_kills_m249 = total_kills_m249,
        total_kills_headshot = total_kills_headshot,
        total_kills_enemy_weapon = total_kills_enemy_weapon,
        total_wins_pistolround = total_wins_pistolround,
        total_wins_map_cs_assault = total_wins_map_cs_assault,
        total_wins_map_cs_italy = total_wins_map_cs_italy,
        total_wins_map_cs_office = total_wins_map_cs_office,
        total_wins_map_de_aztec = total_wins_map_de_aztec,
        total_wins_map_de_cbble = total_wins_map_de_cbble,
        total_wins_map_de_dust2 = total_wins_map_de_dust2,
        total_wins_map_de_inferno = total_wins_map_de_inferno,
        total_wins_map_de_nuke = total_wins_map_de_nuke,
        total_wins_map_de_train = total_wins_map_de_train,
        total_weapons_donated = total_weapons_donated,
        total_broken_windows = total_broken_windows,
        total_kills_enemy_blinded = total_kills_enemy_blinded,
        total_kills_knife_fight = total_kills_knife_fight,
        total_kills_against_zoomed_sniper = total_kills_against_zoomed_sniper,
        total_domination = total_domination,
        total_domination_overkills = total_domination_overkills,
        total_revenges = total_revenges,
        total_shots_hit = total_shots_hit,
        total_shots_fired = total_shots_fired,
        total_rounds_played = total_rounds_played,
        total_shots_deagle = total_shots_deagle,
        total_shots_glock = total_shots_glock,
        total_shots_elite = total_shots_elite,
        total_shots_fiveseven = total_shots_fiveseven,
        total_shots_awp = total_shots_awp,
        total_shots_ak47 = total_shots_ak47,
        total_shots_aug = total_shots_aug,
        total_shots_famas = total_shots_famas,
        total_shots_g3sg1 = total_shots_g3sg1,
        total_shots_p90 = total_shots_p90,
        total_shots_mac10 = total_shots_mac10,
        total_shots_ump45 = total_shots_ump45,
        total_shots_xm1014 = total_shots_xm1014,
        total_shots_m249 = total_shots_m249,
        total_hits_deagle = total_hits_deagle,
        total_hits_glock = total_hits_glock,
        total_hits_elite = total_hits_elite,
        total_hits_fiveseven = total_hits_fiveseven,
        total_hits_awp = total_hits_awp,
        total_hits_ak47 = total_hits_ak47,
        total_hits_aug = total_hits_aug,
        total_hits_famas = total_hits_famas,
        total_hits_g3sg1 = total_hits_g3sg1,
        total_hits_p90 = total_hits_p90,
        total_hits_mac10 = total_hits_mac10,
        total_hits_ump45 = total_hits_ump45,
        total_hits_xm1014 = total_hits_xm1014,
        total_hits_m249 = total_hits_m249,
        total_rounds_map_cs_assault = total_rounds_map_cs_assault,
        total_rounds_map_cs_italy = total_rounds_map_cs_italy,
        total_rounds_map_cs_office = total_rounds_map_cs_office,
        total_rounds_map_de_cbble = total_rounds_map_de_cbble,
        total_rounds_map_de_dust2 = total_rounds_map_de_dust2,
        total_rounds_map_de_inferno = total_rounds_map_de_inferno,
        last_match_t_wins = last_match_t_wins,
        last_match_ct_wins = last_match_ct_wins,
        last_match_wins = last_match_wins,
        last_match_max_players = last_match_max_players,
        last_match_kills = last_match_kills,
        last_match_deaths = last_match_deaths,
        last_match_mvps = last_match_mvps,
        last_match_favweapon_id = last_match_favweapon_id,
        last_match_favweapon_shots = last_match_favweapon_shots,
        last_match_favweapon_hits = last_match_favweapon_hits,
        last_match_favweapon_kills = last_match_favweapon_kills,
        last_match_damage = last_match_damage,
        last_match_money_spent = last_match_money_spent,
        last_match_revenges = last_match_revenges,
        total_rounds_map_de_nuke = total_rounds_map_de_nuke,
        total_rounds_map_de_train = total_rounds_map_de_train,
        total_mvps = total_mvps,
        total_rounds_map_de_lake = total_rounds_map_de_lake,
        total_rounds_map_de_safehouse = total_rounds_map_de_safehouse,
        total_rounds_map_de_sugarcane = total_rounds_map_de_sugarcane,
        total_rounds_map_de_stmarc = total_rounds_map_de_stmarc,
        total_rounds_map_de_bank = total_rounds_map_de_bank,
        total_TR_planted_bombs = total_TR_planted_bombs,
        total_TR_defused_bombs = total_TR_defused_bombs,
        total_gun_game_rounds_won = total_gun_game_rounds_won,
        total_gun_game_rounds_played = total_gun_game_rounds_played,
        total_wins_map_de_house = total_wins_map_de_house,
        total_wins_map_de_bank = total_wins_map_de_bank,
        total_wins_map_de_vertigo = total_wins_map_de_vertigo,
        total_rounds_map_ar_shoots = total_rounds_map_ar_shoots,
        total_wins_map_ar_shoots = total_wins_map_ar_shoots,
        total_wins_map_de_lake = total_wins_map_de_lake,
        total_wins_map_de_sugarcane = total_wins_map_de_sugarcane,
        total_wins_map_de_stmarc = total_wins_map_de_stmarc,
        total_wins_map_de_shorttrain = total_wins_map_de_shorttrain,
        total_wins_map_de_safehouse = total_wins_map_de_safehouse,
        total_matches_won = total_matches_won,
        total_matches_played = total_matches_played,
        total_gg_matches_won = total_gg_matches_won,
        total_gg_matches_played = total_gg_matches_played,
        total_progressive_matches_won = total_progressive_matches_won,
        total_trbomb_matches_won = total_trbomb_matches_won,
        total_contribution_score = total_contribution_score,
        last_match_contribution_score = last_match_contribution_score,
        last_match_rounds = last_match_rounds,
        total_kills_hkp2000 = total_kills_hkp2000,
        total_shots_hkp2000 = total_shots_hkp2000,
        total_hits_p250 = total_hits_p250,
        total_kills_p250 = total_kills_p250,
        total_shots_p250 = total_shots_p250,
        total_kills_sg556 = total_kills_sg556,
        total_shots_sg556 = total_shots_sg556,
        total_hits_sg556 = total_hits_sg556,
        total_kills_scar20 = total_kills_scar20,
        total_shots_scar20 = total_shots_scar20,
        total_hits_scar20 = total_hits_scar20,
        total_shots_ssg08 = total_shots_ssg08,
        total_hits_ssg08 = total_hits_ssg08,
        total_kills_ssg08 = total_kills_ssg08,
        total_shots_mp7 = total_shots_mp7,
        total_hits_mp7 = total_hits_mp7,
        total_kills_mp7 = total_kills_mp7,
        total_kills_mp9 = total_kills_mp9,
        total_shots_mp9 = total_shots_mp9,
        total_hits_mp9 = total_hits_mp9,
        total_hits_nova = total_hits_nova,
        total_kills_nova = total_kills_nova,
        total_shots_nova = total_shots_nova,
        total_hits_negev = total_hits_negev,
        total_kills_negev = total_kills_negev,
        total_shots_negev = total_shots_negev,
        total_hits_sawedoff = total_hits_sawedoff,
        total_kills_sawedoff = total_kills_sawedoff,
        total_shots_sawedoff = total_shots_sawedoff,
        total_hits_bizon = total_hits_bizon,
        total_kills_bizon = total_kills_bizon,
        total_shots_bizon = total_shots_bizon,
        total_kills_tec9 = total_kills_tec9,
        total_shots_tec9 = total_shots_tec9,
        total_hits_tec9 = total_hits_tec9,
        total_kills_mag7 = total_kills_mag7,
        total_shots_mag7 = total_shots_mag7,
        total_hits_mag7 = total_hits_mag7,
        total_gun_game_contribution_score = total_gun_game_contribution_score,
        last_match_gg_contribution_score = last_match_gg_contribution_score,
        total_kills_m4a1 = total_kills_m4a1,
        total_kills_galilar = total_kills_galilar,
        total_kills_molotov = total_kills_molotov,
        total_kills_taser = total_kills_taser,
        total_shots_m4a1 = total_shots_m4a1,
        total_shots_galilar = total_shots_galilar,
        total_shots_taser = total_shots_taser,
        total_hits_m4a1 = total_hits_m4a1,
        total_hits_galilar = total_hits_galilar,
        total_matches_won_train = total_matches_won_train,
        total_rounds_map_de_vertigo = total_rounds_map_de_vertigo,
        total_matches_won_shoots = total_matches_won_shoots,
        total_matches_won_lake = total_matches_won_lake,
        total_matches_won_stmarc = total_matches_won_stmarc,
        total_matches_won_safehouse = total_matches_won_safehouse,
        total_wins_map_cs_militia = total_wins_map_cs_militia,
        total_rounds_map_cs_militia = total_rounds_map_cs_militia,
        GI_lesson_csgo_instr_explain_buymenu = GI_lesson_csgo_instr_explain_buymenu,
        GI_lesson_csgo_instr_explain_buyarmor = GI_lesson_csgo_instr_explain_buyarmor,
        GI_lesson_csgo_instr_explain_plant_bomb = GI_lesson_csgo_instr_explain_plant_bomb,
        GI_lesson_csgo_instr_explain_bomb_carrier = GI_lesson_csgo_instr_explain_bomb_carrier,
        GI_lesson_bomb_sites_A = GI_lesson_bomb_sites_A,
        GI_lesson_csgo_instr_explain_follow_bomber = GI_lesson_csgo_instr_explain_follow_bomber,
        GI_lesson_csgo_instr_explain_pick_bomb = GI_lesson_csgo_instr_explain_pick_bomb,
        GI_lesson_csgo_instr_explain_prevent_bomb_pickup = GI_lesson_csgo_instr_explain_prevent_bomb_pickup,
        GI_lesson_Csgo_cycle_weapons_kb = GI_lesson_Csgo_cycle_weapons_kb,
        GI_lesson_csgo_instr_explain_zoom = GI_lesson_csgo_instr_explain_zoom,
        GI_lesson_csgo_instr_explain_reload = GI_lesson_csgo_instr_explain_reload,
        GI_lesson_tr_explain_plant_bomb = GI_lesson_tr_explain_plant_bomb,
        GI_lesson_bomb_sites_B = GI_lesson_bomb_sites_B,
        GI_lesson_version_number = GI_lesson_version_number,
        GI_lesson_csgo_hostage_load_to_hrz = GI_lesson_csgo_hostage_load_to_hrz,
        GI_lesson_csgo_instr_explain_inspect = GI_lesson_csgo_instr_explain_inspect,
        total_hits_hkp2000 = total_hits_hkp2000,
        total_wins_map_ar_baggage = total_wins_map_ar_baggage,
        total_wins_map_de_dust = total_wins_map_de_dust,
        last_match_dominations = last_match_dominations
    )
}

fun SteamStats.toSteamStatsEntity(): SteamStatsEntity {
    return SteamStatsEntity(
        total_kills = total_kills,
        total_deaths = total_deaths,
        total_time_played = total_time_played,
        total_planted_bombs = total_planted_bombs,
        total_defused_bombs = total_defused_bombs,
        total_wins = total_wins,
        total_damage_done = total_damage_done,
        total_money_earned = total_money_earned,
        total_rescued_hostages = total_rescued_hostages,
        total_kills_knife = total_kills_knife,
        total_kills_hegrenade = total_kills_hegrenade,
        total_kills_glock = total_kills_glock,
        total_kills_deagle = total_kills_deagle,
        total_kills_elite = total_kills_elite,
        total_kills_fiveseven = total_kills_fiveseven,
        total_kills_xm1014 = total_kills_xm1014,
        total_kills_mac10 = total_kills_mac10,
        total_kills_ump45 = total_kills_ump45,
        total_kills_p90 = total_kills_p90,
        total_kills_awp = total_kills_awp,
        total_kills_ak47 = total_kills_ak47,
        total_kills_aug = total_kills_aug,
        total_kills_famas = total_kills_famas,
        total_kills_g3sg1 = total_kills_g3sg1,
        total_kills_m249 = total_kills_m249,
        total_kills_headshot = total_kills_headshot,
        total_kills_enemy_weapon = total_kills_enemy_weapon,
        total_wins_pistolround = total_wins_pistolround,
        total_wins_map_cs_assault = total_wins_map_cs_assault,
        total_wins_map_cs_italy = total_wins_map_cs_italy,
        total_wins_map_cs_office = total_wins_map_cs_office,
        total_wins_map_de_aztec = total_wins_map_de_aztec,
        total_wins_map_de_cbble = total_wins_map_de_cbble,
        total_wins_map_de_dust2 = total_wins_map_de_dust2,
        total_wins_map_de_inferno = total_wins_map_de_inferno,
        total_wins_map_de_nuke = total_wins_map_de_nuke,
        total_wins_map_de_train = total_wins_map_de_train,
        total_weapons_donated = total_weapons_donated,
        total_broken_windows = total_broken_windows,
        total_kills_enemy_blinded = total_kills_enemy_blinded,
        total_kills_knife_fight = total_kills_knife_fight,
        total_kills_against_zoomed_sniper = total_kills_against_zoomed_sniper,
        total_domination = total_domination,
        total_domination_overkills = total_domination_overkills,
        total_revenges = total_revenges,
        total_shots_hit = total_shots_hit,
        total_shots_fired = total_shots_fired,
        total_rounds_played = total_rounds_played,
        total_shots_deagle = total_shots_deagle,
        total_shots_glock = total_shots_glock,
        total_shots_elite = total_shots_elite,
        total_shots_fiveseven = total_shots_fiveseven,
        total_shots_awp = total_shots_awp,
        total_shots_ak47 = total_shots_ak47,
        total_shots_aug = total_shots_aug,
        total_shots_famas = total_shots_famas,
        total_shots_g3sg1 = total_shots_g3sg1,
        total_shots_p90 = total_shots_p90,
        total_shots_mac10 = total_shots_mac10,
        total_shots_ump45 = total_shots_ump45,
        total_shots_xm1014 = total_shots_xm1014,
        total_shots_m249 = total_shots_m249,
        total_hits_deagle = total_hits_deagle,
        total_hits_glock = total_hits_glock,
        total_hits_elite = total_hits_elite,
        total_hits_fiveseven = total_hits_fiveseven,
        total_hits_awp = total_hits_awp,
        total_hits_ak47 = total_hits_ak47,
        total_hits_aug = total_hits_aug,
        total_hits_famas = total_hits_famas,
        total_hits_g3sg1 = total_hits_g3sg1,
        total_hits_p90 = total_hits_p90,
        total_hits_mac10 = total_hits_mac10,
        total_hits_ump45 = total_hits_ump45,
        total_hits_xm1014 = total_hits_xm1014,
        total_hits_m249 = total_hits_m249,
        total_rounds_map_cs_assault = total_rounds_map_cs_assault,
        total_rounds_map_cs_italy = total_rounds_map_cs_italy,
        total_rounds_map_cs_office = total_rounds_map_cs_office,
        total_rounds_map_de_cbble = total_rounds_map_de_cbble,
        total_rounds_map_de_dust2 = total_rounds_map_de_dust2,
        total_rounds_map_de_inferno = total_rounds_map_de_inferno,
        last_match_t_wins = last_match_t_wins,
        last_match_ct_wins = last_match_ct_wins,
        last_match_wins = last_match_wins,
        last_match_max_players = last_match_max_players,
        last_match_kills = last_match_kills,
        last_match_deaths = last_match_deaths,
        last_match_mvps = last_match_mvps,
        last_match_favweapon_id = last_match_favweapon_id,
        last_match_favweapon_shots = last_match_favweapon_shots,
        last_match_favweapon_hits = last_match_favweapon_hits,
        last_match_favweapon_kills = last_match_favweapon_kills,
        last_match_damage = last_match_damage,
        last_match_money_spent = last_match_money_spent,
        last_match_revenges = last_match_revenges,
        total_rounds_map_de_nuke = total_rounds_map_de_nuke,
        total_rounds_map_de_train = total_rounds_map_de_train,
        total_mvps = total_mvps,
        total_rounds_map_de_lake = total_rounds_map_de_lake,
        total_rounds_map_de_safehouse = total_rounds_map_de_safehouse,
        total_rounds_map_de_sugarcane = total_rounds_map_de_sugarcane,
        total_rounds_map_de_stmarc = total_rounds_map_de_stmarc,
        total_rounds_map_de_bank = total_rounds_map_de_bank,
        total_TR_planted_bombs = total_TR_planted_bombs,
        total_TR_defused_bombs = total_TR_defused_bombs,
        total_gun_game_rounds_won = total_gun_game_rounds_won,
        total_gun_game_rounds_played = total_gun_game_rounds_played,
        total_wins_map_de_house = total_wins_map_de_house,
        total_wins_map_de_bank = total_wins_map_de_bank,
        total_wins_map_de_vertigo = total_wins_map_de_vertigo,
        total_rounds_map_ar_shoots = total_rounds_map_ar_shoots,
        total_wins_map_ar_shoots = total_wins_map_ar_shoots,
        total_wins_map_de_lake = total_wins_map_de_lake,
        total_wins_map_de_sugarcane = total_wins_map_de_sugarcane,
        total_wins_map_de_stmarc = total_wins_map_de_stmarc,
        total_wins_map_de_shorttrain = total_wins_map_de_shorttrain,
        total_wins_map_de_safehouse = total_wins_map_de_safehouse,
        total_matches_won = total_matches_won,
        total_matches_played = total_matches_played,
        total_gg_matches_won = total_gg_matches_won,
        total_gg_matches_played = total_gg_matches_played,
        total_progressive_matches_won = total_progressive_matches_won,
        total_trbomb_matches_won = total_trbomb_matches_won,
        total_contribution_score = total_contribution_score,
        last_match_contribution_score = last_match_contribution_score,
        last_match_rounds = last_match_rounds,
        total_kills_hkp2000 = total_kills_hkp2000,
        total_shots_hkp2000 = total_shots_hkp2000,
        total_hits_p250 = total_hits_p250,
        total_kills_p250 = total_kills_p250,
        total_shots_p250 = total_shots_p250,
        total_kills_sg556 = total_kills_sg556,
        total_shots_sg556 = total_shots_sg556,
        total_hits_sg556 = total_hits_sg556,
        total_kills_scar20 = total_kills_scar20,
        total_shots_scar20 = total_shots_scar20,
        total_hits_scar20 = total_hits_scar20,
        total_shots_ssg08 = total_shots_ssg08,
        total_hits_ssg08 = total_hits_ssg08,
        total_kills_ssg08 = total_kills_ssg08,
        total_shots_mp7 = total_shots_mp7,
        total_hits_mp7 = total_hits_mp7,
        total_kills_mp7 = total_kills_mp7,
        total_kills_mp9 = total_kills_mp9,
        total_shots_mp9 = total_shots_mp9,
        total_hits_mp9 = total_hits_mp9,
        total_hits_nova = total_hits_nova,
        total_kills_nova = total_kills_nova,
        total_shots_nova = total_shots_nova,
        total_hits_negev = total_hits_negev,
        total_kills_negev = total_kills_negev,
        total_shots_negev = total_shots_negev,
        total_hits_sawedoff = total_hits_sawedoff,
        total_kills_sawedoff = total_kills_sawedoff,
        total_shots_sawedoff = total_shots_sawedoff,
        total_hits_bizon = total_hits_bizon,
        total_kills_bizon = total_kills_bizon,
        total_shots_bizon = total_shots_bizon,
        total_kills_tec9 = total_kills_tec9,
        total_shots_tec9 = total_shots_tec9,
        total_hits_tec9 = total_hits_tec9,
        total_kills_mag7 = total_kills_mag7,
        total_shots_mag7 = total_shots_mag7,
        total_hits_mag7 = total_hits_mag7,
        total_gun_game_contribution_score = total_gun_game_contribution_score,
        last_match_gg_contribution_score = last_match_gg_contribution_score,
        total_kills_m4a1 = total_kills_m4a1,
        total_kills_galilar = total_kills_galilar,
        total_kills_molotov = total_kills_molotov,
        total_kills_taser = total_kills_taser,
        total_shots_m4a1 = total_shots_m4a1,
        total_shots_galilar = total_shots_galilar,
        total_shots_taser = total_shots_taser,
        total_hits_m4a1 = total_hits_m4a1,
        total_hits_galilar = total_hits_galilar,
        total_matches_won_train = total_matches_won_train,
        total_rounds_map_de_vertigo = total_rounds_map_de_vertigo,
        total_matches_won_shoots = total_matches_won_shoots,
        total_matches_won_lake = total_matches_won_lake,
        total_matches_won_stmarc = total_matches_won_stmarc,
        total_matches_won_safehouse = total_matches_won_safehouse,
        total_wins_map_cs_militia = total_wins_map_cs_militia,
        total_rounds_map_cs_militia = total_rounds_map_cs_militia,
        GI_lesson_csgo_instr_explain_buymenu = GI_lesson_csgo_instr_explain_buymenu,
        GI_lesson_csgo_instr_explain_buyarmor = GI_lesson_csgo_instr_explain_buyarmor,
        GI_lesson_csgo_instr_explain_plant_bomb = GI_lesson_csgo_instr_explain_plant_bomb,
        GI_lesson_csgo_instr_explain_bomb_carrier = GI_lesson_csgo_instr_explain_bomb_carrier,
        GI_lesson_bomb_sites_A = GI_lesson_bomb_sites_A,
        GI_lesson_csgo_instr_explain_follow_bomber = GI_lesson_csgo_instr_explain_follow_bomber,
        GI_lesson_csgo_instr_explain_pick_bomb = GI_lesson_csgo_instr_explain_pick_bomb,
        GI_lesson_csgo_instr_explain_prevent_bomb_pickup = GI_lesson_csgo_instr_explain_prevent_bomb_pickup,
        GI_lesson_Csgo_cycle_weapons_kb = GI_lesson_Csgo_cycle_weapons_kb,
        GI_lesson_csgo_instr_explain_zoom = GI_lesson_csgo_instr_explain_zoom,
        GI_lesson_csgo_instr_explain_reload = GI_lesson_csgo_instr_explain_reload,
        GI_lesson_tr_explain_plant_bomb = GI_lesson_tr_explain_plant_bomb,
        GI_lesson_bomb_sites_B = GI_lesson_bomb_sites_B,
        GI_lesson_version_number = GI_lesson_version_number,
        GI_lesson_csgo_hostage_load_to_hrz = GI_lesson_csgo_hostage_load_to_hrz,
        GI_lesson_csgo_instr_explain_inspect = GI_lesson_csgo_instr_explain_inspect,
        total_hits_hkp2000 = total_hits_hkp2000,
        total_wins_map_ar_baggage = total_wins_map_ar_baggage,
        total_wins_map_de_dust = total_wins_map_de_dust,
        last_match_dominations = last_match_dominations
    )
}

fun PlayerStatsJSON.toSteamStatsEntity(): SteamStatsEntity {

    return SteamStatsEntity(
        total_kills = stats?.get(0)?.value,
        total_deaths = stats?.get(2)?.value,
        total_time_played = stats?.get(3)?.value,
        total_planted_bombs = stats?.get(4)?.value,
        total_defused_bombs = stats?.get(5)?.value,
        total_wins = stats?.get(6)?.value,
        total_damage_done = stats?.get(7)?.value,
        total_money_earned = stats?.get(8)?.value,
        total_rescued_hostages = stats?.get(9)?.value,
        total_kills_knife = stats?.get(10)?.value,
        total_kills_hegrenade = stats?.get(11)?.value,
        total_kills_glock = stats?.get(12)?.value,
        total_kills_deagle = stats?.get(13)?.value,
        total_kills_elite = stats?.get(14)?.value,
        total_kills_fiveseven = stats?.get(15)?.value,
        total_kills_xm1014 = stats?.get(16)?.value,
        total_kills_mac10 = stats?.get(17)?.value,
        total_kills_ump45 = stats?.get(18)?.value,
        total_kills_p90 = stats?.get(18)?.value,
        total_kills_awp = stats?.get(19)?.value,
        total_kills_ak47 = stats?.get(20)?.value,
        total_kills_aug = stats?.get(21)?.value,
        total_kills_famas = stats?.get(22)?.value,
        total_kills_g3sg1 = stats?.get(23)?.value,
        total_kills_m249 = stats?.get(24)?.value,
        total_kills_headshot = stats?.get(25)?.value,
        total_kills_enemy_weapon = stats?.get(26)?.value,
        total_wins_pistolround = stats?.get(27)?.value,
        total_wins_map_cs_assault = stats?.get(28)?.value,
        total_wins_map_cs_italy = stats?.get(29)?.value,
        total_wins_map_cs_office = stats?.get(30)?.value,
        total_wins_map_de_aztec = stats?.get(31)?.value,
        total_wins_map_de_cbble = stats?.get(32)?.value,
        total_wins_map_de_dust2 = stats?.get(33)?.value,
        total_wins_map_de_dust = stats?.get(34)?.value,
        total_wins_map_de_inferno = stats?.get(35)?.value,
        total_wins_map_de_nuke = stats?.get(36)?.value,
        total_wins_map_de_train = stats?.get(37)?.value,
        total_weapons_donated = stats?.get(38)?.value,
        total_broken_windows = stats?.get(39)?.value,
        total_kills_enemy_blinded = stats?.get(40)?.value,
        total_kills_knife_fight = stats?.get(41)?.value,
        total_kills_against_zoomed_sniper = stats?.get(42)?.value,
        total_domination = stats?.get(43)?.value,
        total_domination_overkills = stats?.get(44)?.value,
        total_revenges = stats?.get(45)?.value,
        total_shots_hit = stats?.get(46)?.value,
        total_shots_fired = stats?.get(47)?.value,
        total_rounds_played = stats?.get(48)?.value,
        total_shots_deagle = stats?.get(49)?.value,
        total_shots_glock = stats?.get(50)?.value,
        total_shots_elite = stats?.get(51)?.value,
        total_shots_fiveseven = stats?.get(52)?.value,
        total_shots_awp = stats?.get(53)?.value,
        total_shots_ak47 = stats?.get(54)?.value,
        total_shots_aug = stats?.get(55)?.value,
        total_shots_famas = stats?.get(56)?.value,
        total_shots_g3sg1 = stats?.get(57)?.value,
        total_shots_p90 = stats?.get(58)?.value,
        total_shots_mac10 = stats?.get(59)?.value,
        total_shots_ump45 = stats?.get(60)?.value,
        total_shots_xm1014 = stats?.get(61)?.value,
        total_shots_m249 = stats?.get(62)?.value,
        total_hits_deagle = stats?.get(63)?.value,
        total_hits_glock = stats?.get(64)?.value,
        total_hits_elite = stats?.get(65)?.value,
        total_hits_fiveseven = stats?.get(66)?.value,
        total_hits_awp = stats?.get(67)?.value,
        total_hits_ak47 = stats?.get(68)?.value,
        total_hits_aug = stats?.get(69)?.value,
        total_hits_famas = stats?.get(70)?.value,
        total_hits_g3sg1 = stats?.get(71)?.value,
        total_hits_p90 = stats?.get(72)?.value,
        total_hits_mac10 = stats?.get(73)?.value,
        total_hits_ump45 = stats?.get(74)?.value,
        total_hits_xm1014 = stats?.get(75)?.value,
        total_hits_m249 = stats?.get(76)?.value,
        total_rounds_map_cs_assault = stats?.get(77)?.value,
        total_rounds_map_cs_italy = stats?.get(78)?.value,
        total_rounds_map_cs_office = stats?.get(79)?.value,
        total_rounds_map_de_cbble = stats?.get(80)?.value,
        total_rounds_map_de_dust2 = stats?.get(81)?.value,
        total_rounds_map_de_inferno = stats?.get(82)?.value,
        total_rounds_map_de_nuke = stats?.get(83)?.value,
        total_rounds_map_de_train = stats?.get(84)?.value,
        last_match_t_wins = stats?.get(85)?.value,
        last_match_ct_wins = stats?.get(86)?.value,
        last_match_wins = stats?.get(87)?.value,
        last_match_max_players = stats?.get(88)?.value,
        last_match_kills = stats?.get(89)?.value,
        last_match_deaths = stats?.get(90)?.value,
        last_match_mvps = stats?.get(91)?.value,
        last_match_favweapon_id = stats?.get(92)?.value,
        last_match_favweapon_shots = stats?.get(93)?.value,
        last_match_favweapon_hits = stats?.get(94)?.value,
        last_match_favweapon_kills = stats?.get(95)?.value,
        last_match_damage = stats?.get(96)?.value,
        last_match_money_spent = stats?.get(97)?.value,
        last_match_dominations = stats?.get(98)?.value,
        last_match_revenges = stats?.get(99)?.value,
        total_mvps = stats?.get(100)?.value,
        total_rounds_map_de_lake = stats?.get(101)?.value,
        total_rounds_map_de_safehouse = stats?.get(102)?.value,
        total_rounds_map_de_sugarcane = stats?.get(103)?.value,
        total_rounds_map_de_stmarc = stats?.get(104)?.value,
        total_rounds_map_de_bank = stats?.get(105)?.value,
        total_TR_planted_bombs = stats?.get(106)?.value,
        total_TR_defused_bombs = stats?.get(107)?.value,
        total_gun_game_rounds_won = stats?.get(108)?.value,
        total_gun_game_rounds_played = stats?.get(109)?.value,
        total_wins_map_de_house = stats?.get(110)?.value,
        total_wins_map_de_bank = stats?.get(111)?.value,
        total_wins_map_de_vertigo = stats?.get(112)?.value,
        total_rounds_map_ar_shoots = stats?.get(113)?.value,
        total_wins_map_ar_shoots = stats?.get(114)?.value,
        total_wins_map_ar_baggage = stats?.get(115)?.value,
        total_wins_map_de_lake = stats?.get(116)?.value,
        total_wins_map_de_sugarcane = stats?.get(117)?.value,
        total_wins_map_de_stmarc = stats?.get(118)?.value,
        total_wins_map_de_shorttrain = stats?.get(119)?.value,
        total_wins_map_de_safehouse = stats?.get(120)?.value,
        total_matches_won = stats?.get(121)?.value,
        total_matches_played = stats?.get(122)?.value,
        total_gg_matches_won = stats?.get(123)?.value,
        total_gg_matches_played = stats?.get(124)?.value,
        total_progressive_matches_won = stats?.get(125)?.value,
        total_trbomb_matches_won = stats?.get(126)?.value,
        total_contribution_score = stats?.get(127)?.value,
        last_match_contribution_score = stats?.get(128)?.value,
        last_match_rounds = stats?.get(129)?.value,
        total_kills_hkp2000 = stats?.get(130)?.value,
        total_shots_hkp2000 = stats?.get(131)?.value,
        total_hits_hkp2000 = stats?.get(132)?.value,
        total_hits_p250 = stats?.get(133)?.value,
        total_kills_p250 = stats?.get(134)?.value,
        total_shots_p250 = stats?.get(135)?.value,
        total_kills_sg556 = stats?.get(136)?.value,
        total_shots_sg556 = stats?.get(137)?.value,
        total_hits_sg556 = stats?.get(138)?.value,
        total_hits_scar20 = stats?.get(139)?.value,
        total_kills_scar20 = stats?.get(140)?.value,
        total_shots_scar20 = stats?.get(141)?.value,
        total_shots_ssg08 = stats?.get(142)?.value,
        total_hits_ssg08 = stats?.get(143)?.value,
        total_kills_ssg08 = stats?.get(144)?.value,
        total_shots_mp7 = stats?.get(145)?.value,
        total_hits_mp7 = stats?.get(146)?.value,
        total_kills_mp7 = stats?.get(147)?.value,
        total_kills_mp9 = stats?.get(148)?.value,
        total_shots_mp9 = stats?.get(149)?.value,
        total_hits_mp9 = stats?.get(150)?.value,
        total_hits_nova = stats?.get(151)?.value,
        total_kills_nova = stats?.get(152)?.value,
        total_shots_nova = stats?.get(153)?.value,
        total_hits_negev = stats?.get(154)?.value,
        total_kills_negev = stats?.get(155)?.value,
        total_shots_negev = stats?.get(156)?.value,
        total_shots_sawedoff = stats?.get(157)?.value,
        total_hits_sawedoff = stats?.get(158)?.value,
        total_kills_sawedoff = stats?.get(159)?.value,
        total_shots_bizon = stats?.get(160)?.value,
        total_hits_bizon = stats?.get(161)?.value,
        total_kills_bizon = stats?.get(162)?.value,
        total_kills_tec9 = stats?.get(163)?.value,
        total_shots_tec9 = stats?.get(164)?.value,
        total_hits_tec9 = stats?.get(165)?.value,
        total_shots_mag7 = stats?.get(166)?.value,
        total_hits_mag7 = stats?.get(167)?.value,
        total_kills_mag7 = stats?.get(168)?.value,
        total_gun_game_contribution_score = stats?.get(169)?.value,
        last_match_gg_contribution_score = stats?.get(170)?.value,
        total_kills_m4a1 = stats?.get(171)?.value,
        total_kills_galilar = stats?.get(172)?.value,
        total_kills_molotov = stats?.get(173)?.value,
        total_kills_taser = stats?.get(174)?.value,
        total_shots_m4a1 = stats?.get(175)?.value,
        total_shots_galilar = stats?.get(176)?.value,
        total_shots_taser = stats?.get(177)?.value,
        total_hits_m4a1 = stats?.get(178)?.value,
        total_hits_galilar = stats?.get(179)?.value,
        total_matches_won_train = stats?.get(180)?.value,
        total_rounds_map_de_vertigo = stats?.get(181)?.value,
        total_matches_won_shoots = stats?.get(182)?.value,
        total_matches_won_lake = stats?.get(183)?.value,
        total_matches_won_stmarc = stats?.get(184)?.value,
        total_matches_won_safehouse = stats?.get(185)?.value,
        GI_lesson_csgo_instr_explain_buymenu = stats?.get(186)?.value,
        GI_lesson_csgo_instr_explain_buyarmor = stats?.get(187)?.value,
        GI_lesson_csgo_instr_explain_plant_bomb = stats?.get(188)?.value,
        GI_lesson_csgo_instr_explain_bomb_carrier = stats?.get(189)?.value,
        GI_lesson_bomb_sites_A = stats?.get(190)?.value,
        GI_lesson_csgo_instr_explain_follow_bomber = stats?.get(191)?.value,
        GI_lesson_csgo_instr_explain_pick_bomb = stats?.get(192)?.value,
        GI_lesson_csgo_instr_explain_prevent_bomb_pickup = stats?.get(193)?.value,
        GI_lesson_Csgo_cycle_weapons_kb = stats?.get(194)?.value,
        GI_lesson_csgo_instr_explain_zoom = stats?.get(195)?.value,
        GI_lesson_csgo_instr_explain_reload = stats?.get(196)?.value,
        GI_lesson_tr_explain_plant_bomb = stats?.get(197)?.value,
        GI_lesson_bomb_sites_B = stats?.get(198)?.value,
        GI_lesson_version_number = stats?.get(199)?.value,
        GI_lesson_csgo_hostage_load_to_hrz = stats?.get(200)?.value,
        total_wins_map_cs_militia = stats?.get(201)?.value,
        total_rounds_map_cs_militia = stats?.get(202)?.value,
        GI_lesson_csgo_instr_explain_inspect = stats?.get(203)?.value
    )
}