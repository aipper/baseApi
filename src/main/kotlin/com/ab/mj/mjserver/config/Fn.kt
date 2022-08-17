package com.ab.mj.mjserver.config

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort


fun getPage(index: Int, size: Int, sort: Sort): PageRequest {
    return PageRequest.of(if (index <= 1L) 0 else index, size, sort)
}
