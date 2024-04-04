package com.example.telegram.database

import com.example.telegram.models.UserModel
import io.github.jan.supabase.SupabaseClient

var AUTH: SupabaseClient = getClient()