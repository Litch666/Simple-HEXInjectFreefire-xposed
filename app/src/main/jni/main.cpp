#include <pthread.h>
#include "KittyMemory/MemoryPatch.h"
#include <android/log.h>
#include <jni.h>
#include <iostream>
#include <fstream>
#include <string>

#define LOG_TAG "JuniorModz"

#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

 struct My_Patches {

     MemoryPatch ceu_pretro;
     MemoryPatch bonecobranco1;
     MemoryPatch bonecobranco2;
     MemoryPatch paraquedas;
     MemoryPatch nofog;
     MemoryPatch isfemale;
     MemoryPatch less_recoil;
     MemoryPatch cant_swimming_fire;
     MemoryPatch specialrunspeed;
     MemoryPatch eatspeedscale;
     MemoryPatch speed_fire;
     MemoryPatch view_eagle;
     MemoryPatch chuvabala;
     MemoryPatch walhackv3;
     MemoryPatch walhackv4;
     MemoryPatch medkit;
     MemoryPatch removermira;
     MemoryPatch ghosthackv3;
     MemoryPatch corpogigante;
     MemoryPatch noelinime;
     MemoryPatch noelinime2;
     MemoryPatch noelinime3;
     MemoryPatch noelinime4;
     MemoryPatch noelinime5;
     MemoryPatch noelinime6;
     MemoryPatch noelinime7;
     MemoryPatch noelinime8;
     MemoryPatch noelinime9;
     MemoryPatch noelinime10;
     MemoryPatch aimlock;
     MemoryPatch aimsemi;
     MemoryPatch hitpartybody;
     MemoryPatch bypass;
     MemoryPatch bypass2;
     MemoryPatch bypass3;
     MemoryPatch bypass4;
     MemoryPatch antilogs;
     MemoryPatch antilogs2;
     MemoryPatch antilogs3;


     //Adicionado!

     // etc...
 }patches;

void *is_female(void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.isfemale = MemoryPatch("libil2cpp.so", 0x8f0f68, "\x01\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.isfemale.Modify()){
        LOGI("isfemale = TRUE");
    }
    return NULL;
} //pronto

void *less_recoil(void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.less_recoil = MemoryPatch("libil2cpp.so", 0xAAF09C  , "", 4);
    if (patches.less_recoil.Modify()){
        LOGI("lessrecoil = TRUE");
    }

    return NULL;
}

void *cant_swimming_fire(void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.cant_swimming_fire = MemoryPatch("libil2cpp.so", 0x91B3DC  , "\x01\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.cant_swimming_fire.Modify()){
        LOGI("cant_swimming_fire = TRUE");
    }

    return NULL;
} //pronto

void *special_run_speed (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.specialrunspeed = MemoryPatch("libil2cpp.so", 0x925944 , "\x8C\x0F\x43\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.specialrunspeed.Modify()){
        LOGI("specialrunspeed = TRUE");
    }

    return NULL;
} //pronto

void *eat_speed_scale (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.eatspeedscale = MemoryPatch("libil2cpp.so", 0x944220   , "\x46\x0F\x43\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.eatspeedscale.Modify()){
        LOGI("eatspeedscale = TRUE");
    }

    return NULL;
} //pronto Medkit 3s

void *speed_fire (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.speed_fire = MemoryPatch("libil2cpp.so",  0x12115A0 , "\x50\x0F\x20\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.speed_fire.Modify()){
        LOGI("speed_fire = TRUE");
    }

    return NULL;
} // pronto

void *no_fog(void *) {
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());
    patches.nofog = MemoryPatch("libil2cpp.so", 0x23B461C, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.nofog.Modify()){
        LOGI("nofog modificado = TRUE");
    }

    return NULL;
} //pronto

void *view_eagle (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.view_eagle = MemoryPatch("libil2cpp.so",  0x1F53AA0 , "\xC2\x01\x44\xE3\x1E\xFF\x2F\xE1", 4);
    if (patches.view_eagle.Modify()){
        LOGI("view_eagle = TRUE");
    }

    return NULL;
} //pronto


void *ceu_preto(void *) {
	ProcMap il2cppMap;
	do {
		il2cppMap = KittyMemory::getLibraryMap("libunity.so");
		sleep(1);

	} while(!il2cppMap.isValid());

	if(il2cppMap.isValid()){
	    patches.ceu_pretro = MemoryPatch("libunity.so", 0x1A2280, "\x00\x00\x80\xBF", 4);
	    if (patches.ceu_pretro.Modify()){
            LOGI("ceu preto modificado = TRUE");
	    }
	    else{
            LOGI("ceu preto modificado = FALSE");
	    }

	}

    return NULL;
} //pronto


void *boneco_branco(void *) {
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    if(il2cppMap.isValid()){
        patches.bonecobranco1 = MemoryPatch("libil2cpp.so", 0x90B9EC, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
        patches.bonecobranco2 = MemoryPatch("libil2cpp.so", 0x16F562C, "\x00\x00\x80\xBF", 4);
        if (patches.bonecobranco1.Modify() && patches.bonecobranco2.Modify()){
            LOGI("boneco branco modificado = TRUE");
        }
        else{
            LOGI("boneco branco modificado = FALSE");
        }

    }

    return NULL;
} //pronto

void *para_quedas(void *) {
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    if(il2cppMap.isValid()){
        patches.paraquedas = MemoryPatch("libil2cpp.so", 0x8F2898, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
        if (patches.paraquedas.Modify()){
            LOGI("paraquedas modificado = TRUE");
        }
        else{
            LOGI("paraquedas modificado = FALSE");
        }

    }

    return NULL;
} //pronto

void *chuva_bala (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.chuvabala = MemoryPatch("libil2cpp.so", 0x11D3338, "\x04\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.chuvabala.Modify()){
        LOGI("chuvabala  = TRUE");
    }

    return NULL;
} //pronto

void *wall_hackv3 (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libunity.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.walhackv3 = MemoryPatch("libunity.so",  0xEE679C, "\x00\xC0\x79\xC4\x00\x00\xA0\xE3", 8);
    if (patches.walhackv3.Modify()){
        LOGI("walhackv3  = TRUE");
    }

    return NULL;
} //pronto

void *wall_hackv4 (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.walhackv4 = MemoryPatch("libil2cpp.so",  0x92669C, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.walhackv4.Modify()){
        LOGI("walhackv4  = TRUE");
    }

    return NULL;
} //pronto

void *med_kit (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.medkit = MemoryPatch("libil2cpp.so",  0x1afae94, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.medkit.Modify()){
        LOGI("MedKit  = TRUE");
    }

    return NULL;
} //pronto

void *remover_mira (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.removermira = MemoryPatch("libil2cpp.so",  0x17dde84, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.removermira.Modify()){
        LOGI("removermira  = TRUE");
    }

    return NULL;
} //pronto

void *ghost_v3 (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.ghosthackv3 = MemoryPatch("libil2cpp.so",  0xA92FEC, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.ghosthackv3.Modify()){
        LOGI("ghosthackv3  = TRUE");
    }

    return NULL;
} //pronto

void *corpo_gigante (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libunity.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.corpogigante = MemoryPatch("libunity.so",  0x29BC28, "\x00\x00\xF0\x41", 4);
    if (patches.corpogigante.Modify()){
        LOGI("corpogigante  = TRUE");
    }

    return NULL;
} //pronto

void *no_elinime (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.noelinime = MemoryPatch("libil2cpp.so",  0x923F08, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 68);
    patches.noelinime2 = MemoryPatch("libil2cpp.so",  0x924F4C, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 68);
    patches.noelinime3 = MemoryPatch("libil2cpp.so",  0x924740, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 68);
    patches.noelinime4 = MemoryPatch("libil2cpp.so",  0x923DD8, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 60);
    patches.noelinime5 = MemoryPatch("libil2cpp.so",  0xAF8C3C, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 68);
    patches.noelinime6 = MemoryPatch("libil2cpp.so",  0xAF8E50, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 68);
    patches.noelinime7 = MemoryPatch("libil2cpp.so",  0x924AB0, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 72);
    patches.noelinime8 = MemoryPatch("libil2cpp.so",  0xAAF030, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 68);
    patches.noelinime9 = MemoryPatch("libil2cpp.so",  0x924C20, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 64);
    patches.noelinime9 = MemoryPatch("libil2cpp.so",  0x9240A4, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 64);
    patches.noelinime10 = MemoryPatch("libil2cpp.so",  0x924DC8, "\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3\x00\x20\xF0\xE3", 68);
    if (patches.noelinime.Modify() && patches.noelinime2.Modify() && patches.noelinime3.Modify() && patches.noelinime4.Modify() && patches.noelinime5.Modify() && patches.noelinime6.Modify() && patches.noelinime7.Modify() && patches.noelinime8.Modify() && patches.noelinime9.Modify() && patches.noelinime10.Modify()){
        LOGI("noelimine modificado = TRUE");
    }

    return NULL;
} //prontoo


void *aim_lock (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.aimlock = MemoryPatch("libil2cpp.so",  0x11CAA10,  "\x01\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.aimlock.Modify()){
        LOGI("aimlock  = TRUE");
    }

    return NULL;
} //pronto

void *aim_semi (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.aimsemi = MemoryPatch("libil2cpp.so",  0x120C650, "\x79\x04\x44\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.aimsemi.Modify()){
        LOGI("aimlock  = TRUE");
    }

    return NULL;
} //pronto

void *hit_party_body (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.hitpartybody = MemoryPatch("libil2cpp.so",  0x950218, "\x00\xA0\xA0\xE3", 4);
    if (patches.hitpartybody.Modify()){
        LOGI("hitpartybody  = TRUE");
    }

    return NULL;
} //pronto

void *bypass_mtp (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.bypass = MemoryPatch("libil2cpp.so",  0x1275240, "\x00\xF0\x20\xE3", 4);
    patches.bypass2 = MemoryPatch("libil2cpp.so",  0x1275960, "\x00\xF0\x20\xE3", 4);
    patches.bypass3 = MemoryPatch("libil2cpp.so",  0x127596C, "\x00\xF0\x20\xE3", 4);
    patches.bypass4 = MemoryPatch("libil2cpp.so",  0x1275978, "\x00\xF0\x20\xE3", 4);
    if (patches.bypass.Modify() && patches.bypass2.Modify() && patches.bypass3.Modify() && patches.bypass4.Modify()){
        LOGI("bypass  = TRUE");
    }

    return NULL;
} //pronto

void *anti_logs (void *){
    ProcMap il2cppMap;
    do {
        il2cppMap = KittyMemory::getLibraryMap("libil2cpp.so");
        sleep(1);

    } while(!il2cppMap.isValid());

    patches.antilogs = MemoryPatch("libil2cpp.so",  0xf002d8, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    patches.antilogs2 = MemoryPatch("libil2cpp.so",  0x239f804, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    patches.antilogs3 = MemoryPatch("libil2cpp.so",  0x239774c, "\x00\x00\xA0\xE3\x1E\xFF\x2F\xE1", 8);
    if (patches.antilogs.Modify() && patches.antilogs2.Modify() && patches.antilogs3.Modify()){
        LOGI("antilogs  = TRUE");
    }

    return NULL;
} //pronto


void *readFile(void *){

        LOGI("readFile");
        bool cp = false;
        bool np = false;
        bool nf = false;
        bool isfe = false;
        bool lsrl = false;
        bool cwf = false;
        bool srs = false;
        bool ess = false;
        bool sf = false;
        bool va = false;
        bool cv = false;
        bool v3 = false;
        bool v4 = false;
        bool mk = false;
        bool rm = false;
        bool g3 = false;
        bool cg = false;
        bool nc = false;
        bool aiml = false;
        bool aims = false;
        bool hitp = false;
        bool mtp = false;
        bool ilog = false;

        while (1){
            FILE *f = NULL;
            char line[200];
            f = fopen("/sdcard/sound_tisk.config", "r");
            while(fgets(line,199,f) != NULL){
                LOGI("line = %s", line);


                if (strstr(line, "cg1") || strstr(line, " cg1")){
                    if (!cg){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, corpo_gigante, NULL);
                        cg= !cg;
                    }
                }

                if(strstr(line, "cg0") || strstr(line, " cg0")){
                    if (cg){
                        if(patches.corpogigante.Restore()){
                            LOGI("corpogigante = FALSE");
                            cg = !cg;
                        }
                    }
                }

                if (strstr(line, "g31") || strstr(line, " g31")){
                    if (!g3){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, ghost_v3, NULL);
                        g3= !g3;
                    }
                }

                if(strstr(line, "g30") || strstr(line, " g30")){
                    if (g3){
                        if(patches.ghosthackv3.Restore()){
                            LOGI("ghosthackv3 = FALSE");
                            g3 = !g3;
                        }
                    }
                }

                if (strstr(line, "rm1") || strstr(line, " rm1")){
                    if (!rm){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, remover_mira, NULL);
                        rm= !rm;
                    }
                }

                if(strstr(line, "rm0") || strstr(line, " rm0")){
                    if (rm){
                        if(patches.removermira.Restore()){
                            LOGI("removermira = FALSE");
                            rm = !rm;
                        }
                    }
                }

                if (strstr(line, "mk1") || strstr(line, " mk1")){
                    if (!mk){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, med_kit, NULL);
                        mk= !mk;
                    }
                }

                if(strstr(line, "mk0") || strstr(line, " mk0")){
                    if (mk){
                        if(patches.medkit.Restore()){
                            LOGI("MedKit = FALSE");
                            mk = !mk;
                        }
                    }
                }

                if (strstr(line, "v41") || strstr(line, " v41")){
                    if (!v4){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, wall_hackv4, NULL);
                        v4= !v4;
                    }
                }

                if(strstr(line, "v40") || strstr(line, " v40")){
                    if (v4){
                        if(patches.walhackv4.Restore()){
                            LOGI("WalhackV4 = FALSE");
                            v4 = !v4;
                        }
                    }
                }

                if (strstr(line, "v31") || strstr(line, " v31")){
                    if (!v3){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, wall_hackv3, NULL);
                        v3= !v3;
                    }
                }

                if(strstr(line, "v30") || strstr(line, " v30")){
                    if (v3){
                        if(patches.walhackv3.Restore()){
                            LOGI("Walhackv3 = FALSE");
                            v3 = !v3;
                        }
                    }
                }

                if (strstr(line, "cv1") || strstr(line, " cv1")){
                    if (!cv){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, chuva_bala, NULL);
                        cv= !cv;
                    }
                }

                if(strstr(line, "cv0") || strstr(line, " cv0")){
                    if (cv){
                        if(patches.chuvabala.Restore()) {
                            LOGI("chuvabala = FALSE");
                            cv = !cv;
                        }
                    }
                }

                if (strstr(line, "va1") || strstr(line, " va1")){
                    if (!va){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, view_eagle, NULL);
                        va= !va;
                    }
                }

                if(strstr(line, "va0") || strstr(line, " va0")){
                    if (va){
                        if(patches.view_eagle.Restore()){
                            LOGI("view_eagle = FALSE");
                            va= !va;
                        }
                    }
                }

                if (strstr(line, "isfe1") || strstr(line, " isfe1")){
                    if (!isfe){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, is_female, NULL);
                        isfe = !isfe;
                    }
                }

                if(strstr(line, "isfe0") || strstr(line, " isfe0")){
                    if (isfe){
                        if(patches.isfemale.Restore()){
                            LOGI("isfemale = FALSE");
                            isfe = !isfe;
                        }
                    }
                }

                if (strstr(line, "lsrl1") || strstr(line, " lsrl1")){
                    if (!lsrl){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, less_recoil, NULL);
                        lsrl = !lsrl;
                    }
                }

                if(strstr(line, "lsrl0") || strstr(line, " lsrl0")){
                    if (lsrl){
                        if(patches.less_recoil.Restore()){
                            LOGI("lessrecoil = FALSE");
                            lsrl = !lsrl;
                        }
                    }
                }

                if (strstr(line, "cwf1") || strstr(line, " cwf1")){
                    if (!cwf){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, cant_swimming_fire, NULL);
                        cwf = !cwf;
                    }
                }

                if(strstr(line, "cwf0") || strstr(line, " cwf0")){
                    if (cwf){
                        if(patches.cant_swimming_fire.Restore()){
                            LOGI("cant_swimming_fire = FALSE");
                            cwf = !cwf;
                        }
                    }
                }

                if (strstr(line, "srs1") || strstr(line, " srs1")){
                    if (!srs){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, special_run_speed , NULL);
                        srs= !srs;
                    }
                }

                if(strstr(line, "srs0") || strstr(line, " srs0")){
                    if (srs){
                        if(patches.specialrunspeed.Restore()){
                            LOGI("specialrunspeed = FALSE");
                            srs = !srs;
                        }
                    }
                }

                if (strstr(line, "ess1") || strstr(line, " ess1")){
                    if (!ess){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, eat_speed_scale, NULL);
                        ess= !ess;
                    }
                }

                if(strstr(line, "ess0") || strstr(line, " ess0")){
                    if (ess){
                        if(patches.eatspeedscale.Restore()){
                            LOGI("eatspeedscale = FALSE");
                            ess= !ess;
                        }
                    }
                }

                if (strstr(line, "sf1") || strstr(line, " sf1")){
                    if (!sf){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, speed_fire , NULL);
                        sf = !sf;
                    }
                }

                if(strstr(line, "sf0") || strstr(line, " sf0")){
                    if (sf){
                        if(patches.speed_fire.Restore()){
                            LOGI("speedfire = FALSE");
                            sf= !sf;
                        }
                    }
                }


/* ##############################################################################*/
                if (strstr(line, "cp1") || strstr(line, " cp1")){
                    if (!cp){
                        pthread_t ptid;
                        pthread_create(&ptid, NULL, ceu_preto, NULL);
                        cp = !cp;
                    }
                }

                if(strstr(line, "cp0") || strstr(line, " cp0")){
                    if (cp){
                        if(patches.ceu_pretro.Restore()){
                            LOGI("ceupreto = FALSE");
                            cp= !cp;
                        }
                    }
                }

                if(strstr(line, "np1") || strstr(line, " np1")){
                    if (!np){
                        pthread_t ptidpq;
                        pthread_create(&ptidpq, NULL, para_quedas, NULL);
                        np = !np;
                    }

                }

                if (strstr(line, "np0") || strstr(line, " np0")){
                    if(np){
                        if (patches.paraquedas.isValid()){
                            if (patches.paraquedas.Restore()){
                                LOGI("no paraquedas = false");
                                np = !np;
                            }
                        }
                    }
                }

                if(strstr(line, "nf1") || strstr(line, " nf1")){
                    pthread_t ptidnf;
                    pthread_create(&ptidnf, NULL, no_fog, NULL);
                }

                if (strstr(line, "nf0") || strstr(line, " nf0")){
                    if (patches.nofog.isValid()){
                        if (patches.nofog.Restore()) {
                            LOGI("no fog= false");
                        }
                    }
                }
            }

            if (strstr(line, "nc1") || strstr(line, " nc1")){
                if (!nc){
                    pthread_t ptid;
                    pthread_create(&ptid, NULL, no_elinime, NULL);
                    nc= !nc;
                }
            }

            if(strstr(line, "nc0") || strstr(line, " nc0")){
                if (nc){
                    if(patches.noelinime.Restore()){
                        LOGI("noelinime = FALSE");
                        nc = !nc;
                    }
                }
            }

            if (strstr(line, "aiml1") || strstr(line, " aiml1")){
                if (!aiml){
                    pthread_t ptid;
                    pthread_create(&ptid, NULL, aim_lock, NULL);
                    aiml= !aiml;
                }
            }

            if(strstr(line, "aiml0") || strstr(line, " aiml0")){
                if (aiml){
                    if(patches.aimlock.Restore()){
                        LOGI("AimLock = FALSE");
                        aiml = !aiml;
                    }
                }
            }

            if (strstr(line, "aims1") || strstr(line, " aims1")){
                if (!aims){
                    pthread_t ptid;
                    pthread_create(&ptid, NULL, aim_semi, NULL);
                    aims= !aims;
                }
            }

            if(strstr(line, "aims0") || strstr(line, " aims0")){
                if (aims){
                    if(patches.aimsemi.Restore()){
                        LOGI("AimSemi = FALSE");
                        aims = !aims;
                    }
                }
            }

            if (strstr(line, "hitp1") || strstr(line, " hitp1")){
                if (!hitp){
                    pthread_t ptid;
                    pthread_create(&ptid, NULL, hit_party_body, NULL);
                    hitp= !hitp;
                }
            }

            if(strstr(line, "hitp0") || strstr(line, " hitp0")){
                if (hitp){
                    if(patches.hitpartybody.Restore()){
                        LOGI("HitParty = FALSE");
                        hitp = !hitp;
                    }
                }
            }

            if (strstr(line, "mtp1") || strstr(line, " mtp1")){
                if (!mtp){
                    pthread_t ptid;
                    pthread_create(&ptid, NULL, bypass_mtp, NULL);
                    mtp= !mtp;
                }
            }

            if(strstr(line, "mtp0") || strstr(line, " mtp0")){
                if (mtp){
                    if(patches.bypass.Restore()){
                        LOGI("Bypass = FALSE");
                        mtp = !hitp;
                    }
                }
            }

            if (strstr(line, "ilog1") || strstr(line, " ilog1")){
                if (!ilog){
                    pthread_t ptid;
                    pthread_create(&ptid, NULL, anti_logs, NULL);
                    ilog= !ilog;
                }
            }

            if(strstr(line, "ilog0") || strstr(line, " ilog0")){
                if (ilog){
                    if(patches.antilogs.Restore()){
                        LOGI("Bypass = FALSE");
                        ilog = !ilog;
                    }
                }
            }

            sleep(1);
    }
    return NULL;
}


__attribute__((constructor))
void initializer() {
    LOGI("começou");

    FILE *f = NULL;
    f = fopen("/sdcard/sound_tisk.config", "r");
    if (f == NULL)
        fopen("/sdcard/sound_tisk.config", "w+");

    pthread_t ptid;
    pthread_create(&ptid, NULL, readFile, NULL);
}